package com.luv2code.jdbc.employeesearch.dao;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.luv2code.jdbc.employeesearch.core.AuditHistory;
import com.luv2code.jdbc.employeesearch.core.Employee;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class EmployeeDAO {

	private Connection myConn;
	
	public EmployeeDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("Employee DAO - DB connection successful to: " + dburl);
	}
	
	public void updateEmployee(Employee theEmployee, int userId) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update employees"
					+ " set first_name=?, last_name=?, email=?, salary=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setBigDecimal(4, theEmployee.getSalary());
			myStmt.setInt(5, theEmployee.getId());
			
			// execute SQL
			myStmt.executeUpdate();
			
			//
			// Add audit history
			//

			// prepare statement
			myStmt = myConn.prepareStatement("insert into audit_history"
					+ " (user_id, employee_id, action, action_date_time)"
					+ " values (?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, userId);
			myStmt.setInt(2, theEmployee.getId());
			myStmt.setString(3, "Updated employee.");			
			myStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			// execute SQL
			myStmt.executeUpdate();	
			
		}
		finally {
			DAOUtils.close(myStmt);
		}
		
	}
	
	public void addEmployee(Employee theEmployee, int userId) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into employees"
					+ " (first_name, last_name, email, salary)"
					+ " values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			// set params
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setBigDecimal(4, theEmployee.getSalary());
			
			// execute SQL
			myStmt.executeUpdate();	
			
			// get the generated employee id
			ResultSet generatedKeys = myStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				theEmployee.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Error generating key for employee");
			}
	            
			//
			// Add audit history
			//
			
			// prepare statement
			myStmt = myConn.prepareStatement("insert into audit_history"
					+ " (user_id, employee_id, action, action_date_time)"
					+ " values (?, ?, ?, ?)");
			
			// set params
			myStmt.setInt(1, userId);
			myStmt.setInt(2, theEmployee.getId());
			myStmt.setString(3, "Added new employee.");
			myStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			
			// execute SQL
			myStmt.executeUpdate();	
			
		}
		finally {
			DAOUtils.close(myStmt);
		}
		
	}
		
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employees order by last_name");
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}
	
	public List<Employee> searchEmployees(String lastName) throws Exception {
		List<Employee> list = new ArrayList<Employee>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = myConn.prepareStatement("select * from employees where last_name like ?  order by last_name");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");
		BigDecimal salary = myRs.getBigDecimal("salary");
		
		Employee tempEmployee = new Employee(id, lastName, firstName, email, salary);
		
		return tempEmployee;
	}


	public List<AuditHistory> getAuditHistory(int employeeId) throws Exception {
		List<AuditHistory> list = new ArrayList<AuditHistory>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = "SELECT history.user_id, history.employee_id, history.action, history.action_date_time, users.first_name, users.last_name  "
					+ "FROM audit_history history, users users "
					+ "WHERE history.user_id=users.id AND history.employee_id=" + employeeId;
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				
				int userId = myRs.getInt("history.user_id");
				String action = myRs.getString("history.action");
				
				Timestamp timestamp = myRs.getTimestamp("history.action_date_time");
				java.util.Date actionDateTime = new java.util.Date(timestamp.getTime());
				
				String userFirstName = myRs.getString("users.first_name");
				String userLastName = myRs.getString("users.last_name");
				
				AuditHistory temp = new AuditHistory(userId, employeeId, action, actionDateTime, userFirstName, userLastName);
				
				list.add(temp);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.searchEmployees("thom"));

		System.out.println(dao.getAllEmployees());
		
		System.out.println(dao.getAuditHistory(4));
	}

}

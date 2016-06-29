package com.luv2code.jdbc.employeesearch.dao;

import java.io.FileInputStream;
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

import com.luv2code.jdbc.employeesearch.core.Employee;
import com.luv2code.jdbc.employeesearch.core.User;
import com.luv2code.jdbc.employeesearch.util.PasswordUtils;

public class UserDAO {

	private Connection myConn;
	
	public UserDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("UserDAO - DB connection successful to: " + dburl);
	}
	
	private User convertRowToUser(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");

		boolean admin = myRs.getBoolean("is_admin");
		User tempUser = new User(id, lastName, firstName, email, admin);
		
		return tempUser;
	}
	
	public List<User> getUsers(boolean admin, int userId) throws Exception {
		List<User> list = new ArrayList<User>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			
			String sql = null;
			
			if (admin) {
				// get all users
				sql = "select * from users order by last_name";
			}
			else {
				// only the current user
				sql = "select * from users where id=" + userId + " order by last_name";
			}
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}

			return list;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}
	}	
	
	public void addUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into users"
					+ " (first_name, last_name, email, is_admin, password)"
					+ " values (?, ?, ?, ?, ?)");
			
			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setBoolean(4, theUser.isAdmin());
			
			// encrypt password
			String encryptedPassword = PasswordUtils.encryptPassword(theUser.getPassword());
			myStmt.setString(5, encryptedPassword);
			
			// execute SQL
			myStmt.executeUpdate();				
		}
		finally {
			DAOUtils.close(myStmt);
		}
		
	}
		
	
	public void updateUser(User theUser) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set first_name=?, last_name=?, email=?, is_admin=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getEmail());
			myStmt.setBoolean(4, theUser.isAdmin());
			myStmt.setInt(5, theUser.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		
	}
	
	/**
	 * Return true if user's password is authenticated.
	 * 
	 * @param theUser
	 * @return
	 */
	public boolean authenticate(User theUser) throws Exception {
		boolean result = false;
		
		String plainTextPassword = theUser.getPassword();
		
		// get the encrypted password from database for this user
		String encryptedPasswordFromDatabase = getEncrpytedPassword(theUser.getId());
		
		// compare the passwords
		result = PasswordUtils.checkPassword(plainTextPassword, encryptedPasswordFromDatabase);
		
		return result;
	}

	private String getEncrpytedPassword(int id) throws Exception {
		String encryptedPassword = null;
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select password from users where id=" + id);
			
			if (myRs.next()) {
				encryptedPassword = myRs.getString("password");
			}
			else {
				throw new Exception("User id not found: " + id);
			}

			return encryptedPassword;		
		}
		finally {
			DAOUtils.close(myStmt, myRs);
		}		
	}

	public void changePassword(User user) throws Exception {

		// get plain text password
		String plainTextPassword = user.getPassword();
		
		// encrypt the password
		String encryptedPassword = PasswordUtils.encryptPassword(plainTextPassword);
		
		// update the password in the database
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update users"
					+ " set password=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, encryptedPassword);
			myStmt.setInt(2, user.getId());
			
			// execute SQL
			myStmt.executeUpdate();

		}
		finally {
			DAOUtils.close(myStmt);
		}		

	}	
}

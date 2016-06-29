package com.luv2code.jdbc.employeesearch.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.luv2code.jdbc.employeesearch.core.AuditHistory;
import com.luv2code.jdbc.employeesearch.core.Employee;
import com.luv2code.jdbc.employeesearch.core.User;
import com.luv2code.jdbc.employeesearch.dao.EmployeeDAO;
import com.luv2code.jdbc.employeesearch.dao.UserDAO;
import com.luv2code.jdbc.employeesearch.ui.audithistory.AuditHistoryDialog;
import com.luv2code.jdbc.employeesearch.ui.employees.EmployeeDialog;
import com.luv2code.jdbc.employeesearch.ui.employees.EmployeeTableModel;
import com.luv2code.jdbc.employeesearch.ui.users.ChangePasswordDialog;
import com.luv2code.jdbc.employeesearch.ui.users.UserDialog;
import com.luv2code.jdbc.employeesearch.ui.users.UserLoginDialog;
import com.luv2code.jdbc.employeesearch.ui.users.UserTableModel;

public class EmployeeSearchApp extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable employeeTable;

	private UserDAO userDAO;
	private EmployeeDAO employeeDAO;
	private JPanel employeesButtonPanel;
	private JButton btnAddEmployee;
	private JButton btnUpdateEmployee;
	private JButton viewHistoryButton;
	
	private int userId;
	private JPanel topPanel;
	private JPanel searchPanel;
	private JLabel lblLoggedIn;
	private JLabel loggedInUserLabel;
	private JPanel employeePanel;
	private JTabbedPane tabbedPane;
	private JPanel usersPanel;
	private JScrollPane userScrollPane;
	private JTable userTable;
	private JPanel panel;
	private JButton addUserButton;
	private JButton updateUser;
	private JButton changePasswordButton;
	private JPanel panel_1;
	
	private boolean admin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					EmployeeDAO employeeDAO = new EmployeeDAO();
					UserDAO userDAO = new UserDAO();
					
					// Get users
					List<User> users = userDAO.getUsers(true, 0);

					// Show login dialog
					UserLoginDialog dialog = new UserLoginDialog();
					dialog.populateUsers(users);
					dialog.setEmployeeDAO(employeeDAO);
					dialog.setUserDAO(userDAO);
					
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeSearchApp(int theUserId, boolean theAdmin, EmployeeDAO theEmployeeDAO, UserDAO theUserDAO) {
		
		userId = theUserId;
		admin = theAdmin;
		
		employeeDAO = theEmployeeDAO;
		userDAO = theUserDAO;
		
		setTitle("Employee Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		employeePanel = new JPanel();
		tabbedPane.addTab("Employees", null, employeePanel, null);
		employeePanel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		employeePanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		employeeTable = new JTable();
		panel_1.add(employeeTable.getTableHeader(), BorderLayout.NORTH);
		panel_1.add(employeeTable, BorderLayout.CENTER);
		
		searchPanel = new JPanel();
		employeePanel.add(searchPanel, BorderLayout.NORTH);
		searchPanel.setBorder(null);
		FlowLayout flowLayout_1 = (FlowLayout) searchPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JLabel lblEnterLastName = new JLabel("Enter last name");
		searchPanel.add(lblEnterLastName);
		
		lastNameTextField = new JTextField();
		searchPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		btnSearch = new JButton("Search");
		searchPanel.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get last name from the text field

				// Call DAO and get employees for the last name

				// If last name is empty, then get all employees

				// Print out employees				
				
				try {
					String lastName = lastNameTextField.getText();

					List<Employee> employees = null;

					if (lastName != null && lastName.trim().length() > 0) {
						employees = employeeDAO.searchEmployees(lastName);
					} else {
						employees = employeeDAO.getAllEmployees();
					}
					
					// create the model and update the "table"
					EmployeeTableModel model = new EmployeeTableModel(employees);
					
					employeeTable.setModel(model);
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		
		scrollPane = new JScrollPane();
		
		employeesButtonPanel = new JPanel();
		employeePanel.add(employeesButtonPanel, BorderLayout.SOUTH);
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create dialog
				EmployeeDialog dialog = new EmployeeDialog(EmployeeSearchApp.this, employeeDAO, userId);

				// show dialog
				dialog.setVisible(true);
			}
		});
		employeesButtonPanel.add(btnAddEmployee);
		
		btnUpdateEmployee = new JButton("Update Employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// get the selected item
				int row = employeeTable.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current employee
				Employee tempEmployee = (Employee) employeeTable.getValueAt(row, EmployeeTableModel.OBJECT_COL);
				
				// create dialog
				EmployeeDialog dialog = new EmployeeDialog(EmployeeSearchApp.this, employeeDAO, 
															tempEmployee, true, userId);

				// show dialog
				dialog.setVisible(true);
			
			}
		});
		employeesButtonPanel.add(btnUpdateEmployee);
		
		viewHistoryButton = new JButton("View History");
		viewHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get the selected item
				int row = employeeTable.getSelectedRow();
				
				// make sure a row is selected
				if (row < 0) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select an employee", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;
				}
				
				// get the current employee
				Employee tempEmployee = (Employee) employeeTable.getValueAt(row, EmployeeTableModel.OBJECT_COL);

				try {
					// get audit history for this employee
					int employeeId = tempEmployee.getId();
					List<AuditHistory> auditHistoryList = employeeDAO.getAuditHistory(employeeId);

					// show audit history dialog
					AuditHistoryDialog dialog = new AuditHistoryDialog();
					dialog.populate(tempEmployee, auditHistoryList);
					
					dialog.setVisible(true);
				}
				catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error retrieving audit history", "Error",
							JOptionPane.ERROR_MESSAGE);				
					return;					
				}
				
			}
		});
		employeesButtonPanel.add(viewHistoryButton);
		
		usersPanel = new JPanel();
		tabbedPane.addTab("Users", null, usersPanel, null);
		usersPanel.setLayout(new BorderLayout(0, 0));
		
		userScrollPane = new JScrollPane();
		usersPanel.add(userScrollPane, BorderLayout.CENTER);
		
		userTable = new JTable();
		usersPanel.add(userTable.getTableHeader(), BorderLayout.NORTH);
		usersPanel.add(userTable, BorderLayout.CENTER);
		
		panel = new JPanel();
		usersPanel.add(panel, BorderLayout.SOUTH);
		
		addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		panel.add(addUserButton);
		
		updateUser = new JButton("Update User");
		updateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});
		panel.add(updateUser);
		
		changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		panel.add(changePasswordButton);
		
		topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		FlowLayout flowLayout_2 = (FlowLayout) topPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		lblLoggedIn = new JLabel("Logged In:");
		topPanel.add(lblLoggedIn);
		
		loggedInUserLabel = new JLabel("New label");
		topPanel.add(loggedInUserLabel);

		addUserButton.setEnabled(admin);
		
		refreshUsersView();
	}

	public void refreshUsersView() {

		try {
			List<User> users = userDAO.getUsers(admin, userId);

			// create the model and update the "table"
			UserTableModel model = new UserTableModel(users);

			userTable.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void refreshEmployeesView() {

		try {
			List<Employee> employees = employeeDAO.getAllEmployees();

			// create the model and update the "table"
			EmployeeTableModel model = new EmployeeTableModel(employees);

			employeeTable.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void setLoggedInUserName(String firstName, String lastName) {
		loggedInUserLabel.setText(firstName + " " + lastName);
	}
	
	private void addUser() {
		UserDialog userDialog = new UserDialog(EmployeeSearchApp.this, userDAO, false);
		
		userDialog.setVisible(true);
	}
	
	protected void updateUser() {

		// get the selected item
		int row = userTable.getSelectedRow();
		
		// make sure a row is selected
		if (row < 0) {
			JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select a user", "Error",
					JOptionPane.ERROR_MESSAGE);				
			return;
		}
		
		// get the current employee
		User tempUser = (User) userTable.getValueAt(row, UserTableModel.OBJECT_COL);
		
		// create dialog
		UserDialog dialog = new UserDialog(EmployeeSearchApp.this, userDAO, tempUser);

		// show dialog
		dialog.setVisible(true);		
	}
	
	protected void changePassword() {
		// get the selected item
		int row = userTable.getSelectedRow();
		
		// make sure a row is selected
		if (row < 0) {
			JOptionPane.showMessageDialog(EmployeeSearchApp.this, "You must select a user", "Error",
					JOptionPane.ERROR_MESSAGE);				
			return;
		}
		
		// get the current employee
		User tempUser = (User) userTable.getValueAt(row, UserTableModel.OBJECT_COL);

		// create dialog
		ChangePasswordDialog changePasswordDialog = new ChangePasswordDialog(tempUser, userDAO);
		
		// show dialog
		changePasswordDialog.setVisible(true);
	}
	
	public int getCurrentUserId() {
		return userId;
	}
	
	public void setAdmin(boolean theFlag) {
		admin = theFlag;
		addUserButton.setEnabled(theFlag);		
	}
	
}

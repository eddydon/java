package com.luv2code.jdbc.employeesearch.ui.users;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.luv2code.jdbc.employeesearch.core.User;
import com.luv2code.jdbc.employeesearch.dao.EmployeeDAO;
import com.luv2code.jdbc.employeesearch.dao.UserDAO;
import com.luv2code.jdbc.employeesearch.ui.EmployeeSearchApp;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class UserLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JComboBox userComboBox;

	private EmployeeDAO employeeDAO;
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	public void setEmployeeDAO(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	public void populateUsers(List<User> users) {
		userComboBox.setModel(new DefaultComboBoxModel(users.toArray(new User[0])));
	}

	/**
	 * Create the dialog.
	 */
	public UserLoginDialog() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("User Login");
		setBounds(100, 100, 450, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel lblUser = new JLabel("User");
			contentPanel.add(lblUser, "2, 2, right, default");
		}
		{
			userComboBox = new JComboBox();
			contentPanel.add(userComboBox, "4, 2, fill, default");
		}
		{
			JLabel lblPassword = new JLabel("Password");
			contentPanel.add(lblPassword, "2, 4, right, default");
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField, "4, 4, fill, default");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						performUserLogin();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JComboBox getUserComboBox() {
		return userComboBox;
	}

	private void performUserLogin() {
		
		try {
			// get the user id
			if (userComboBox.getSelectedIndex() == -1) {						
				JOptionPane.showMessageDialog(UserLoginDialog.this, "You must select a user.", "Error", JOptionPane.ERROR_MESSAGE);				
				return;
			}

			User theUser = (User) userComboBox.getSelectedItem();
			int userId = theUser.getId();
			boolean admin = theUser.isAdmin();
			
			// get the password
			String plainTextPassword = new String(passwordField.getPassword());
			theUser.setPassword(plainTextPassword);

			// check the user's password against the encrypted version in the database
			boolean isValidPassword = userDAO.authenticate(theUser);

			if (isValidPassword) {
				// hide the login window
				setVisible(false);

				// now show the main app window
				EmployeeSearchApp frame = new EmployeeSearchApp(userId, admin, employeeDAO, userDAO);
				frame.setLoggedInUserName(theUser.getFirstName(), theUser.getLastName());

				frame.setVisible(true);
			}
			else {
				// show error message
				JOptionPane.showMessageDialog(this, "Invalid login", "Invalid Login",
						JOptionPane.ERROR_MESSAGE);

				return;			
			}
		}
		catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error during login", "Error",
					JOptionPane.ERROR_MESSAGE);			
		}
	}
}

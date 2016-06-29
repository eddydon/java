package com.luv2code.jdbc.employeesearch.ui.users;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.luv2code.jdbc.employeesearch.core.User;
import com.luv2code.jdbc.employeesearch.dao.UserDAO;
import com.luv2code.jdbc.employeesearch.ui.EmployeeSearchApp;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

	private User user;
	private UserDAO userDAO;
	private JLabel userNameLabel;
	
	public ChangePasswordDialog(User theUser, UserDAO theUserDAO) {
		
		this();
		
		user = theUser;
		userDAO = theUserDAO;
		
		userNameLabel.setText(theUser.getFirstName() + " " + theUser.getLastName());
	}
	
	/**
	 * Create the dialog.
	 */
	public ChangePasswordDialog() {
		setTitle("Change Password");
		setBounds(100, 100, 450, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblUser = new JLabel("User:");
				panel.add(lblUser);
			}
			{
				userNameLabel = new JLabel("New label");
				panel.add(userNameLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
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
				JLabel lblNewLabel = new JLabel("Password");
				lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblNewLabel, "2, 2, right, default");
			}
			{
				passwordField = new JPasswordField();
				panel.add(passwordField, "4, 2, fill, default");
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Confirm Password");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblNewLabel_1, "2, 4, right, default");
			}
			{
				confirmPasswordField = new JPasswordField();
				panel.add(confirmPasswordField, "4, 4, fill, default");
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changePassword();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void changePassword() {
		
		// validate password
		String password = new String(passwordField.getPassword());
		String confirmPassword = new String(confirmPasswordField.getPassword());
		
		if (!password.equals(confirmPassword)) {

			JOptionPane.showMessageDialog(ChangePasswordDialog.this, "Passwords do not match.", "Error",
					JOptionPane.ERROR_MESSAGE);				
			return;			
		}
					
		// change the password in the database
		try {
			user.setPassword(password);
			userDAO.changePassword(user);

			setVisible(false);
			
			JOptionPane.showMessageDialog(ChangePasswordDialog.this, "Password updated successfully.", "Password Updated",
					JOptionPane.INFORMATION_MESSAGE);				
		}
		catch (Exception exc) {
			JOptionPane.showMessageDialog(ChangePasswordDialog.this, "Error updating password.", "Error",
					JOptionPane.ERROR_MESSAGE);				
		}
	}
	
}

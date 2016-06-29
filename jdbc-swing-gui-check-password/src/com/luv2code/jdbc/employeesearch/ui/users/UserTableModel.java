package com.luv2code.jdbc.employeesearch.ui.users;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.luv2code.jdbc.employeesearch.core.Employee;
import com.luv2code.jdbc.employeesearch.core.User;

public class UserTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;
	private static final int IS_ADMIN_COL = 3;

	private String[] columnNames = { "Last Name", "First Name", "Email",
			"Is Admin" };
	private List<User> users;

	public UserTableModel(List<User> theUsers) {
		users = theUsers;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		User tempUser = users.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempUser.getLastName();
		case FIRST_NAME_COL:
			return tempUser.getFirstName();
		case EMAIL_COL:
			return tempUser.getEmail();
		case IS_ADMIN_COL:
			return tempUser.isAdmin();
		case OBJECT_COL:
			return tempUser;
		default:
			return tempUser.getLastName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}	
}

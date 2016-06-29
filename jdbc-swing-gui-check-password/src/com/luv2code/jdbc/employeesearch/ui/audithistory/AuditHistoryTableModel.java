package com.luv2code.jdbc.employeesearch.ui.audithistory;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.luv2code.jdbc.employeesearch.core.AuditHistory;

public class AuditHistoryTableModel extends AbstractTableModel {

	public static final int OBJECT_COL = -1;
	public static final int DATE_TIME_COL = 0;
	private static final int ACTION_COL = 1;
	private static final int USER_FIRST_NAME_COL = 2;
	private static final int USER_LAST_NAME_COL = 3;

	private String[] columnNames = { "Date/Time", "Action", "User First Name",
			"User Last Name" };
	
	private List<AuditHistory> auditHistoryList;

	public AuditHistoryTableModel(List<AuditHistory> theAuditHistoryList) {
		auditHistoryList = theAuditHistoryList;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return auditHistoryList.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		AuditHistory tempAuditHistory = auditHistoryList.get(row);

		switch (col) {
		case DATE_TIME_COL:			
			return tempAuditHistory.getActionDateTime();
		case ACTION_COL:
			return tempAuditHistory.getAction();
		case USER_FIRST_NAME_COL:
			return tempAuditHistory.getUserFirstName();
		case USER_LAST_NAME_COL:
			return tempAuditHistory.getUserLastName();
		case OBJECT_COL:
			return tempAuditHistory;
		default:
			return tempAuditHistory.getUserLastName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}

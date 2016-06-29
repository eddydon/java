package com.luv2code.jdbc.employeesearch.core;

import java.util.Date;

public class AuditHistory {

	private int userId;
	private int employeeId;
	private String action;
	private Date actionDateTime;
	
	private String userFirstName;
	private String userLastName;
	
	
	public AuditHistory(int userId, int employeeId, String action,
			Date actionDateTime, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.employeeId = employeeId;
		this.action = action;
		this.actionDateTime = actionDateTime;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getActionDateTime() {
		return actionDateTime;
	}
	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

	@Override
	public String toString() {
		return String
				.format("AuditHistory [userId=%s, employeeId=%s, action=%s, actionDateTime=%s, userFirstName=%s, userLastName=%s]",
						userId, employeeId, action, actionDateTime,
						userFirstName, userLastName);
	}
	
	
	
}

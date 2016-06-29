package pkgCISS;

import java.util.Date;

public class Schedule {

	private int scheduleID;
	private int clID;
	private int lID;
	private int cID;
	private Date calendarDate;
	private int duration;
	
	Schedule() {
		scheduleID = 0;
		clID = 0;
		lID = 0;
		cID = 0;
		calendarDate = null;
		duration = 0;
	}
	
	Schedule(int scheduleID, int clID, int lID, int cID, Date calendarDate, int duration) {
		this.scheduleID = scheduleID;
		this.clID = clID;
		this.lID = lID;
		this.cID = cID;
		this.calendarDate = calendarDate;
		this.duration = duration;
	}
	
	public int getScheduleID() {
		return scheduleID;
	}
	
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	
	public int getClID() {
		return clID;
	}
	
	public void setClID(int clID) {
		this.clID = clID;
	}
	
	public int getlID() {
		return lID;
	}
	
	public void setlID(int lID) {
		this.lID = lID;
	}
	
	public int getcID() {
		return cID;
	}
	
	public void setcID(int cID) {
		this.cID = cID;
	}
	
	/** Return Calendar Date **/
	public java.util.Date getCalendarDate() {
		return calendarDate;
	}
	
	/*public Date getCalendarDate() {
		return calendarDate;
	}*/
	
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public static void viewAppts(String range, int ID, char viewType){
		
	}
	
	public void scheduleAppts(){
	
	}
}

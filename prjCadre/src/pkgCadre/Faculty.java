package pkgCadre;

public class Faculty {
	private int facID;
	private String fName;
	private String lName;
	private String title;
	private String college;
	private String years;
	private String dept;
	private String degree;
	private short phone;
	private String email;
	private String password;
	private boolean admin;
	
	// Default Constructor
	public Faculty() {
		super();
		facID = 0;
		fName = "";
		lName = "";
		title = "";
		college = "";
		years = "";
		dept = "";
		degree = "";
		phone = 0;
		email = "";
		password = "";
		admin = false;
	}
	
	// Overloaded Constructor
	public Faculty(int facID, String fName, String lName, String title, String college, String years, String dept,
			String degree, short phone, String email, String password, boolean admin) {
		super();
		this.facID = facID;
		this.fName = fName;
		this.lName = lName;
		this.title = title;
		this.college = college;
		this.years = years;
		this.dept = dept;
		this.degree = degree;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}
	
	// Getters and Setters
	public int getFacID() {
		return facID;
	}
	public void setFacID(int facID) {
		this.facID = facID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public short getPhone() {
		return phone;
	}
	public void setPhone(short phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
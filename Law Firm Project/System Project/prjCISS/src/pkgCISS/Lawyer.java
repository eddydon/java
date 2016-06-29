package pkgCISS;

public class Lawyer {

	private int lID;
	private String lUsername;
	private String lPassword;
	private String lFName;
	private String lLName;
	private String lTelephone;
	
	Lawyer(){
		lID = 0;
		lUsername = "";
		lPassword = "";
		lFName = "";
		lLName = "";
		lTelephone = "";
	}
	
	Lawyer(int lID, String lUsername, String lPassword, String lFName, String lLName, String lTelephone){
		this.lID = lID;
		this.lUsername = lUsername;
		this.lPassword = lPassword;
		this.lFName = lFName;
		this.lLName = lLName;
		this.lTelephone = lTelephone;
	}

	public String getlUsername() {
		return lUsername;
	}

	public void setlUsername(String lUsername) {
		this.lUsername = lUsername;
	}

	public int getlID() {
		return lID;
	}

	public void setlID(int lID) {
		this.lID = lID;
	}

	public String getlPassword() {
		return lPassword;
	}

	public void setlPassword(String lPassword) {
		this.lPassword = lPassword;
	}

	public String getlFName() {
		return lFName;
	}

	public void setlFName(String lFName) {
		this.lFName = lFName;
	}

	public String getlLName() {
		return lLName;
	}

	public void setlLName(String lLName) {
		this.lLName = lLName;
	}

	public String getlTelephone() {
		return lTelephone;
	}

	public void setlTelephone(String lTelephone) {
		this.lTelephone = lTelephone;
	}
}

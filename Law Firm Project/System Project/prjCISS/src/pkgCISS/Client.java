package pkgCISS;

public class Client {

	private int clID;
	private String clUsername;
	private String clPassword;
	private String clTitle;
	private String clFName;
	private String clLName;
	private String clTelephone;
	private String clAddress;
	private String clCity;
	private String clState;
	private int clZipCode;
	private String clEmail;
	
	Client(){
		clID = 0;
		clUsername 	= "";
		clPassword 	= "";
		clTitle 	= "";
		clFName 	= "";
		clLName 	= "";
		clTelephone = "";
		clAddress 	= "";
		clCity 		= "";
		clState 	= "";
		clZipCode 	= 0;
		clEmail 	= "";
	}
	
	Client(int clID, String clUsername, String clPassword, String clTitle, String clFName, String clLName, String clTelephone, String clAddress, String clCity, String clState, int clZipCode, String clEmail){
		this.clID 		= clID;
		this.clUsername = clUsername;
		this.clPassword = clPassword;
		this.clTitle 	= clTitle;
		this.clFName 	= clFName;
		this.clLName 	= clLName;
		this.clTelephone = clTelephone;
		this.clAddress 	= clAddress;
		this.clCity 	= clCity;
		this.clState 	= clState;
		this.clZipCode 	= clZipCode;
		this.clEmail 	= clEmail;
	}

	public int getClID() {
		return clID;
	}

	public void setClID(int clID) {
		this.clID = clID;
	}

	public String getClUsername() {
		return clUsername;
	}

	public void setClUsername(String clUsername) {
		this.clUsername = clUsername;
	}

	public String getClPassword() {
		return clPassword;
	}

	public void setClPassword(String clPassword) {
		this.clPassword = clPassword;
	}

	public String getClTitle() {
		return clTitle;
	}

	public void setClTitle(String clTitle) {
		this.clTitle = clTitle;
	}

	public String getClFName() {
		return clFName;
	}

	public void setClFName(String clFName) {
		this.clFName = clFName;
	}

	public String getClLName() {
		return clLName;
	}

	public void setClLName(String clLName) {
		this.clLName = clLName;
	}

	public String getClTelephone() {
		return clTelephone;
	}

	public void setClTelephone(String clTelephone) {
		this.clTelephone = clTelephone;
	}

	public String getClAddress() {
		return clAddress;
	}

	public void setClAddress(String clAddress) {
		this.clAddress = clAddress;
	}

	public String getClCity() {
		return clCity;
	}

	public void setClCity(String clCity) {
		this.clCity = clCity;
	}

	public String getClState() {
		return clState;
	}

	public void setClState(String clState) {
		this.clState = clState;
	}

	public int getClZipCode() {
		return clZipCode;
	}

	public void setClZipCode(int clZipCode) {
		this.clZipCode = clZipCode;
	}

	public String getClEmail() {
		return clEmail;
	}

	public void setClEmail(String clEmail) {
		this.clEmail = clEmail;
	}
	
	
}

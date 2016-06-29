package pkgTIMS_JS;


public class Customer {
	private int custID;
	//Variables WITH card
	private String title;
	private String fName;
	private String lName;
	private String username;
	private String password;
	//Variables WITHOUT card
	private int SSN;
	private String uniqueID;
	private String sightkey;
	//Address
	private int houseNum;
	private String streetName;
	private String city;
	private String state;
	private int zipcode;
	private String phoneNum;
	private String email;
	
	//DEFAULT CONSTRUCTORS
	public Customer() {
		custID = 0;
		title = "";
		fName = "";
		lName = "";
		username = "";
		password = "";
		SSN = 0;
		uniqueID = "";
		sightkey = "";
		houseNum = 0;
		streetName = "";
		city = "";
		state = "";
		zipcode = 0;
		phoneNum = "";
		email = "";
	}

	//OVERLOADED CONSTRUCTORS
	public Customer(int cid, String ti, String fn, String ln,
			String un, String pw, int sn, String uid,
			String sk, int hn, String stn, String ci,
			String sta, int zc, String pn, String em) {
		super();
		custID = cid;
		title = ti;
		fName = fn;
		lName = ln;
		username = un;
		password = pw;
		SSN = sn;
		uniqueID = uid;
		sightkey = sk;
		houseNum = hn;
		streetName = stn;
		city = ci;
		state = sta;
		zipcode = zc;
		phoneNum = pn;
		email = em;
	}
	
	//GETTERS AND SETTERS

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getSightkey() {
		return sightkey;
	}

	public void setSightkey(String sightkey) {
		this.sightkey = sightkey;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}

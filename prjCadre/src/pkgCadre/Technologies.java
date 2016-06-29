package pkgCadre;

public class Technologies {
	private int techID;
	private String technology;
	private int catID;
	private String description;
	private String website;
	private double minPrice;
	private double maxPrice;
	private short phone;
	private boolean techSupport;

	// Default Constructors
	public Technologies() {
		super();
		techID = 0;
		technology = "";
		catID = 0;
		description = "";
		website = "";
		minPrice = 0;
		maxPrice = 0;
		phone = 0;
		techSupport = false;
	}

	// Overloaded Constructors
	public Technologies(int tid, String tech, int cid, String desc, String web, double minP,
			double maxP, short p, boolean techS) {
		super();
		techID = tid;
		technology = tech;
		catID = cid;
		description = desc;
		website = web;
		minPrice = minP;
		maxPrice = maxP;
		phone = p;
		techSupport = techS;
	}
	
	// Getters and Setters
	public int getTechID() {
		return techID;
	}
	public void setTechID(int techID) {
		this.techID = techID;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getCatID() {
		return catID;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public short getPhone() {
		return phone;
	}
	public void setPhone(short phone) {
		this.phone = phone;
	}
	public boolean isTechSupport() {
		return techSupport;
	}
	public void setTechSupport(boolean techSupport) {
		this.techSupport = techSupport;
	}
}
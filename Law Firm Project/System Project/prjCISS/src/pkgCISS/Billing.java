package pkgCISS;

public class Billing {

	private int billID;
	private float hourlyRate;
	private String coding;
	private String description;
	
	Billing(){
		billID = 0;
		hourlyRate = 0.00f;
		coding = "";
		description = "";
	}
	
	Billing(int billID, float hourlyRate, String coding, String description){
		this.billID = billID;
		this.hourlyRate = hourlyRate;
		this.coding = coding;
		this.description = description;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

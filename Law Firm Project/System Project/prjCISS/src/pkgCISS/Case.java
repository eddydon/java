package pkgCISS;


public class Case {

	private int cID;
	private String cType;
	private String caseName;
	private String court;
	private String outcome;
	private String description;
	private String practicearea;
	private String dateopen;
	private String dateclosed;
	
	Case(){
		cID = 0;
		cType = "";
		caseName = "";
		court = "";
		outcome = "";
		description = "";
		practicearea = "";
		dateopen = "";
		dateclosed = "";
	}
	
	Case(int cID, String cType, String caseName, String court, String outcome, String description, String practicearea, String dateopen, String dateclosed){
		this.cID = cID;
		this.cType = cType;
		this.caseName = caseName;
		this.court = court;
		this.outcome = outcome;
		this.description = description;
		this.practicearea = practicearea;
		this.dateopen = dateopen;
		this.dateclosed = dateclosed;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}
	
	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPracticearea() {
		return practicearea;
	}

	public void setPracticearea(String practicearea) {
		this.practicearea = practicearea;
	}

	public String getDateopen() {
		return dateopen;
	}

	public void setDateopen(String dateopen) {
		this.dateopen = dateopen;
	}

	public String getDateclosed() {
		return dateclosed;
	}

	public void setDateclosed(String dateclosed) {
		this.dateclosed = dateclosed;
	}
}

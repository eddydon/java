package pkgCadre;

public class Outcomes {
	private int oid;
	private String outcome;

	// Default Constructor
	public Outcomes() {
		super();
		oid = 0;
		outcome = "";
	}
		
	// 	Overloaded Constructor
	public Outcomes(int oid, String outcome) {
		super();
		this.oid = oid;
		this.outcome = outcome;
	}
		
	// Getters and Setters	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
}
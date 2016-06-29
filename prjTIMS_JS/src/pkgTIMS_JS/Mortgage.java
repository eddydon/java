package pkgTIMS_JS;

public class Mortgage {
	private int custID;
	private String mloanDate;
	private double homeValue;
	private double mortLoanAmount;
	private double mortAnnualInterestRate;
	private int mortLoanTerm;
	private double mortMonthlyPayment;
	private double totalPayments;
	
	/** Default Constructor **/
	public Mortgage(){
		custID = 0;
		mloanDate = "";
		homeValue = 0;
		mortLoanAmount = 0;
		mortAnnualInterestRate = 0;
		mortLoanTerm = 0;
		mortMonthlyPayment = 0;
		totalPayments = 0;
	}
	
	/** Overloaded Constructor 
	 * @param custID **/
	public Mortgage(int cid, String mld, double hv, double mla, double mair, int mlt, 
			double mmp, double tp){
		custID = cid;
		mloanDate = mld;
		homeValue = hv;
		mortLoanAmount = mla;
		mortAnnualInterestRate = mair;
		mortLoanTerm = mlt;
		mortMonthlyPayment = mmp;
		totalPayments = tp;
	}

	/**
	 * @return the custID
	 */
	public int getCustID() {
		return custID;
	}

	/**
	 * @param custID the custID to set
	 */
	public void setCustID(int custID) {
		this.custID = custID;
	}

	/**
	 * @return the mloanDate
	 */
	public String getMloanDate() {
		return mloanDate;
	}

	/**
	 * @param mloanDate the mloanDate to set
	 */
	public void setMloanDate(String mloanDate) {
		this.mloanDate = mloanDate;
	}

	/**
	 * @return the homeValue
	 */
	public double getHomeValue() {
		return homeValue;
	}

	/**
	 * @param homeValue the homeValue to set
	 */
	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}

	/**
	 * @return the mortLoanAmount
	 */
	public double getMortLoanAmount() {
		return mortLoanAmount;
	}

	/**
	 * @param mortLoanAmount the mortLoanAmount to set
	 */
	public void setMortLoanAmount(double mortLoanAmount) {
		this.mortLoanAmount = mortLoanAmount;
	}

	/**
	 * @return the mortAnnualInterestRate
	 */
	public double getMortAnnualInterestRate() {
		return mortAnnualInterestRate;
	}

	/**
	 * @param mortAnnualInterestRate the mortAnnualInterestRate to set
	 */
	public void setMortAnnualInterestRate(double mortAnnualInterestRate) {
		this.mortAnnualInterestRate = mortAnnualInterestRate;
	}

	/**
	 * @return the mortLoanTerm
	 */
	public int getMortLoanTerm() {
		return mortLoanTerm;
	}

	/**
	 * @param mortLoanTerm the mortLoanTerm to set
	 */
	public void setMortLoanTerm(int mortLoanTerm) {
		this.mortLoanTerm = mortLoanTerm;
	}

	/**
	 * @return the mortMonthlyPayment
	 */
	public double getMortMonthlyPayment() {
		return mortMonthlyPayment;
	}

	/**
	 * @param mortMonthlyPayment the mortMonthlyPayment to set
	 */
	public void setMortMonthlyPayment(double mortMonthlyPayment) {
		this.mortMonthlyPayment = mortMonthlyPayment;
	}

	/**
	 * @return the totalPayments
	 */
	public double getTotalPayments() {
		return totalPayments;
	}

	/**
	 * @param totalPayments the totalPayments to set
	 */
	public void setTotalPayments(double totalPayments) {
		this.totalPayments = totalPayments;
	}
}

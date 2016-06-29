package pkgTIMS_JS;

public class CreditCard {
	private int custID;
	private String loanDate;
	private float annualInterestRate;
	private double loanAmount;
	private double balance;
	private int loanTerm;
	private double ccMonthlyPayment;

	//Default Constructor
	public CreditCard(){
		custID = 0;
		loanDate = "";
		annualInterestRate = 0.00f;
		loanAmount = 0;
		balance = 0;
		loanTerm = 0;
		ccMonthlyPayment = 0;
	}
	
	//Overloaded Constructor
	public CreditCard(int cid,String ld, float air, double la, double bal, int lt, double cmp){
		custID = cid;
		loanDate = ld;
		annualInterestRate = air;
		loanAmount = la;
		balance = bal;
		loanTerm = lt;
		ccMonthlyPayment = cmp;
	}

	//Getters and Setters
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public float getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(float annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getCcMonthlyPayment() {
		return ccMonthlyPayment;
	}

	public void setCcMonthlyPayment(double ccMonthlyPayment) {
		this.ccMonthlyPayment = ccMonthlyPayment;
	}
}

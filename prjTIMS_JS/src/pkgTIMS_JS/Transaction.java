package pkgTIMS_JS;

public class Transaction {
		private int transCount;
		private int custID;
		private int transNum;
		private String transType;
		private String transDate;

		//DEFAULT CONSTRUCTORS
		public Transaction() {
			transCount = 0;
			custID = 0;
			transNum = 0;
			transType = "";
			transDate = "";
		}
		
		//OVERLOADED CONSTRUCTORS
		public Transaction(int tc, int cid, int tn, String tt, String td) {
			super();
			transCount = tc;
			custID = cid;
			transNum = tn;
			transType = tt;
			transDate = td;
		}

		//GETTERS AND SETTERS
		public int getTransCount() {
			return transCount;
		}

		public void setTransCount(int transCount) {
			this.transCount = transCount;
		}

		public int getCustID() {
			return custID;
		}

		public void setCustID(int custID) {
			this.custID = custID;
		}

		public int getTransNum() {
			return transNum;
		}

		public void setTransNum(int transNum) {
			this.transNum = transNum;
		}

		public String getTransType() {
			return transType;
		}

		public void setTransType(String transType) {
			this.transType = transType;
		}

		public String getTransDate() {
			return transDate;
		}

		public void setTransDate(String transDate) {
			this.transDate = transDate;
		}
	}

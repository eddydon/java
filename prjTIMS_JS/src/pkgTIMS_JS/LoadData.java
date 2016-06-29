package pkgTIMS_JS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoadData {
	public static Account accounts[] = new Account[2];
	public static Customer people[] = new Customer[2];
	public static CreditCard credit[] = new CreditCard[2];
	public static Mortgage mortgage[] = new Mortgage[2];
	public static Transaction trans[] = new Transaction[100];

	LoadData()
	{
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Bank11.mdb");
			Statement st = conn.createStatement();
			System.out.println("Connected database successfully ...");
		
			//Retrieve data from Salesperson table
			String sqlAccount = "SELECT * FROM tblAccount";
			ResultSet rsAccount = st.executeQuery(sqlAccount);
			
			//Loop through the results to load the data into the Salesperson array
			while (rsAccount.next())
			{
				//Retrieve by column name
				int cid = rsAccount.getInt("custID");
				int can = rsAccount.getInt("checkingAcctNum");
				int san = rsAccount.getInt("savingsAcctNum");
				int soan = rsAccount.getInt("soarAcctNum");
				String ccan = rsAccount.getString("creditCardAcctNum");
				int man = rsAccount.getInt("mortgageAcctNum");
				int clan = rsAccount.getInt("carLoanAcctNum");
				double cab = rsAccount.getDouble("checkingAcctBal");
				double sab = rsAccount.getDouble("savingsAcctBal");
				double soab = rsAccount.getDouble("soarAcctBal");
				
				//Load record into the Salesperson array
				accounts[i] = new Account(cid,can,san,soan,ccan,man,clan,cab,sab,soab);
				//System.out.println(accounts[i].getCustID());
				i++;
			}
		
			rsAccount.close();
			System.out.println("Loaded Accounts successfully...");
			
			//Retrieve data from the Customer table
			String sqlCustomer = "SELECT * FROM tblCustomer";
			ResultSet rsCustomer = st.executeQuery(sqlCustomer);
			i = 0;
					
			//Loop through the results to load the data into the Customer array
			while (rsCustomer.next()) 
			{	
				//Retrieve by column name
				int cid = rsCustomer.getInt("custID");
				String ti = rsCustomer.getString("title");
				String fn = rsCustomer.getString("fName");
				String ln = rsCustomer.getString("lName");
				String un = rsCustomer.getString("username");
				String pw = rsCustomer.getString("password");
				int sn = rsCustomer.getInt("SSN");
				String uid = rsCustomer.getString("uniqueID");
				String sk = rsCustomer.getString("sightkey");
				int hn = rsCustomer.getInt("houseNum");
				String stn = rsCustomer.getString("streetName");
				String ci = rsCustomer.getString("city");
				String sta = rsCustomer.getString("state");
				int zc = rsCustomer.getInt("zipcode");
				String pn = rsCustomer.getString("phoneNum");
				String em = rsCustomer.getString("email");
				
				//Load record into the Customer array
				people[i] = new Customer(cid,ti,fn,ln,un,pw,sn,uid,sk,hn,stn,ci,sta,zc,pn,em);
				i++;
			}
		
			
			rsCustomer.close();
		
			//Retrieve data from the Car table
			String sqlCreditCard = "SELECT * FROM tblCreditCard";
			ResultSet rsCreditCard = st.executeQuery(sqlCreditCard);
			i = 0;
			
			//Loop through the results to load the data into the Customer array		
			while (rsCreditCard.next()) 
			{
				//Retrieve by column name
				int cid = rsCreditCard.getInt("custID");
				String ld = rsCreditCard.getString("loanDate");
				float air = rsCreditCard.getFloat("annualInterestRate");
				double la = rsCreditCard.getDouble("loanAmount");
				double bal = rsCreditCard.getDouble("balance");
				int lt = rsCreditCard.getInt("loanTerm");
				double cmp = rsCreditCard.getDouble("ccMonthlyPayment");
				
				//Load record into the Car array
				credit[i] = new CreditCard(cid,ld,air,la,bal,lt,cmp);
				i++;
			}
			
			
				//Close the result sets and the connection
				rsCreditCard.close();

				//Retrieve data from the Car table
				String sqlMortgage = "SELECT * FROM tblMortgage";
				ResultSet rsMortgage = st.executeQuery(sqlMortgage);
				i = 0;
				
				//Loop through the results to load the data into the Customer array		
				while (rsMortgage.next()) 
			{
				//Retrieve by column name
				int cid = rsMortgage.getInt("custID");
				String mld = rsMortgage.getString("mloanDate");
				float hv = rsMortgage.getFloat("homeValue");
				double mla = rsMortgage.getDouble("mortLoanAmount");
				double mair = rsMortgage.getDouble("mortAnnualInterestRate");
				int mlt = rsMortgage.getInt("mortLoanTerm");
				double mmp = rsMortgage.getDouble("mortMonthlyPayment");
				double tp = rsMortgage.getDouble("totalPayments");
				
				//Load record into the Car array
				mortgage[i] = new Mortgage(cid,mld,hv,mla,mair,mlt,mmp,tp);
				i++;
			}
			    //Close the result sets and the connection
				rsMortgage.close();
				
				//Retrieve data from the Car table
				String sqlTransaction = "SELECT * FROM tblTransaction";
				ResultSet rsTransaction = st.executeQuery(sqlTransaction);
				i = 0;
				
				//Loop through the results to load the data into the Customer array		
				while (rsTransaction.next()) 
				{
					//Retrieve by column name
					int tc = rsTransaction.getInt("transCount");
					int cid = rsTransaction.getInt("custID");
					int tn = rsTransaction.getInt("transNum");
					String tt = rsTransaction.getString("transType");
					String td = rsTransaction.getString("transDate");
					
					//Load record into the Car array
					trans[i] = new Transaction(tc,cid,tn,tt,td);
					i++;
				}
					
					//Close the result sets and the connection
					rsTransaction.close();
				conn.close();
		}
		catch (Exception e)
		{
			System.out.println("can't get" +e);
		}
	}
}
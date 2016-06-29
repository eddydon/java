package pkgCISS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class LoadData {
	
	public static Billing invoice[] 	= new Billing[3];
	public static Case folder[] 		= new Case[3];
	public static Client customer[] 	= new Client[3];
	public static Lawyer counselor[] 	= new Lawyer[3];
	public static Schedule agenda[] 	= new Schedule[3];
	
	LoadData() {
		
		int i = 0;
		try
		{
			//Connect to the database
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:/MEC 2014-2015/Projects/prjCISS/CISS.mdb");
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://CISS.mdb");
			Statement st = conn.createStatement();
			System.out.println("Connected C.I.S.S. database successfully ...");
		
			//Retrieve data from Case table
			String sqlCase = "SELECT * FROM tblCase";
			ResultSet rsCase = st.executeQuery(sqlCase);
			
			//Loop through the results to load the data into the Case array
			while (rsCase.next())
			{
				//Retrieve by column name
				int cID = rsCase.getInt("cID");
				String cType = rsCase.getString("cType");
				String caseName = rsCase.getString("caseName");
				String court = rsCase.getString("court");
				String outcome = rsCase.getString("outcome");
				String description = rsCase.getString("description");
				String practicearea = rsCase.getString("practicearea");
				String dateopen = rsCase.getString("dateopen");
				String dateclosed = rsCase.getString("dateclosed");
				
				//Load record into the Case array
				folder[i] = new Case(cID, cType, caseName, court, outcome, description, practicearea, dateopen, dateclosed);
				i++;
			}
		
			rsCase.close();
			System.out.println("Loaded tblCase successfully...");
			
			//Retrieve data from the Billing table
			String sqlBilling = "SELECT * FROM tblBilling";
			ResultSet rsBilling = st.executeQuery(sqlBilling);
			i = 0;
					
			//Loop through the results to load  the data into the Customer array
			while (rsBilling.next()) 
			{	
				//Retrieve by column name
				int billID = rsBilling.getInt("billID");
				float hourlyRate = rsBilling.getFloat("hourlyRate");
				String coding = rsBilling.getString("coding");
				String description = rsBilling.getString("description");
				
				//Load record into the Billing array
				invoice[i] = new Billing(billID, hourlyRate, coding, description);
				i++;
			}
		
			
			rsBilling.close();
			System.out.println("Loaded tblBilling successfully...");
		
			//Retrieve data from the Client table
			String sqlClient = "SELECT * FROM tblClient";
			ResultSet rsClient = st.executeQuery(sqlClient);
			i = 0;
			
			//Loop through the results to load the data into the Client array		
			while (rsClient.next()) 
			{
				//Retrieve by column name
				int clID = rsClient.getInt("clID");
				String clUsername = rsClient.getString("clUsername");;
				String clPassword = rsClient.getString("clPassword");;
				String clTitle = rsClient.getString("clTitle");;
				String clFName = rsClient.getString("clFName");;
				String clLName = rsClient.getString("clLName");;
				String clTelephone = rsClient.getString("clTelephone");;
				String clAddress = rsClient.getString("clAddress");;
				String clCity = rsClient.getString("clCity");;
				String clState = rsClient.getString("clState");;
				int clZipCode = rsClient.getInt("clZipCode");;
				String clEmail = rsClient.getString("clEmail");;
				
				//Load record into the Car array
				customer[i] = new Client(clID, clUsername, clPassword, clTitle, clFName, clLName, clTelephone, clAddress, clCity, clState, clZipCode, clEmail);
				i++;
			}
			
			
				//Close the result sets and the connection
				rsClient.close();
				System.out.println("Loaded tblClient successfully...");

				//Retrieve data from the Lawyer table
				String sqlLawyer = "SELECT * FROM tblLawyer";
				ResultSet rsLawyer = st.executeQuery(sqlLawyer);
				i = 0;
				
				//Loop through the results to load the data into the Lawyer array		
				while (rsLawyer.next()) 
			{
				//Retrieve by column name
				int lID = rsLawyer.getInt("lID");;
				String lUsername = rsLawyer.getString("lUsername");
				String lPassword = rsLawyer.getString("lPassword");;
				String lFName = rsLawyer.getString("lFName");;
				String lLName = rsLawyer.getString("lLName");;
				String lTelephone = rsLawyer.getString("lTelephone");;
				
				
				//Load record into the Lawyer array
				counselor[i] = new Lawyer(lID, lUsername, lPassword, lFName, lLName, lTelephone);
				i++;
			}
			    //Close the result sets and the connection
				rsLawyer.close();
				System.out.println("Loaded tblLawyer successfully...");
				
				//Retrieve data from the Car table
				String sqlSchedule = "SELECT * FROM tblSchedule";
				ResultSet rsSchedule = st.executeQuery(sqlSchedule);
				i = 0;
				
				//Loop through the results to load the data into the Customer array		
				while (rsSchedule.next()) 
				{
					//Retrieve by column name
					int scheduleID = rsSchedule.getInt("scheduleID");;
					int clID = rsSchedule.getInt("clID");;
					int lID = rsSchedule.getInt("lID");;
					int cID = rsSchedule.getInt("cID");;
					Date calendarDate = rsSchedule.getDate("calendarDate");
					int duration = rsSchedule.getInt("duration");;
					
					//Load record into the Car array
					agenda[i] = new Schedule(scheduleID, clID, lID, cID, calendarDate, duration);
					i++;
				}
					
					//Close the result sets and the connection
					rsSchedule.close();
					System.out.println("Loaded tblSchedule successfully...");
					
				conn.close();
		}
		catch (Exception e)
		{
			System.out.println("can't get" + e);
		}
	}
}
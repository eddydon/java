package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class DepositCheckWindow extends JFrame {
	
		public static int i = 0;
		
		double DTSoar, DTChecking, DTSavings, newCB, newSB, newSoB;
		double checkAmount;
		
		int transNum = 4;
		String transType = "Deposit";
	
		// Get current date time
		java.util.Date date = new java.util.Date(); 
		Timestamp ts = new Timestamp(date.getTime()); 
		
	DepositCheckWindow(int customerindex) throws IOException, ParseException{
		
		// Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		// Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		// Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon check = new ImageIcon("images/check.png");
		JLabel lblCheck = new JLabel(check);
		lblCheck.setPreferredSize(new Dimension(48, 48));
		
		//Set date to be shown on window
		DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy"); //h:mm a
		Calendar cal = Calendar.getInstance();
		JLabel lblDate = new JLabel(dateFormat.format(cal.getTime()));
		lblDate.setFont(new Font("Helvetica", Font.BOLD, 10));
		lblDate.setForeground(new Color(251, 251, 251));
		
	    // Add the panel to the content page
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(255, 255, 255));
		
		// Welcome user
		JLabel lblHello = new JLabel("Hello, "+LoadData.people[customerindex].getTitle()+". "+LoadData.people[customerindex].getlName()+".");
		lblHello.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblHello.setForeground(new Color(251, 125, 24));
		
		// User select message
		JLabel lblSelect = new JLabel("Select transfer accounts and enter transfer amount below.");
		lblSelect.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblSelect.setForeground(new Color(251, 125, 24));
		
		// create a combo box with items specified in the String array:
		String[] transferTo = new String[] { "Checking Account", "Savings Account", "SOAR Account" };
		final JComboBox<String> toList = new JComboBox<String>(transferTo);

		// customize some appearance:
		toList.setFont(new Font("Helvetica", Font.PLAIN, 12));
		toList.setBackground(new Color(255, 255, 255));
		
		// make the combo box editable so we can add new item when needed
		toList.setEditable(false);
		//Create the labels.

	    JFormattedTextField txtAmt = new JFormattedTextField(new DecimalFormat("#.00"));
	    txtAmt.setValue(new Double(123.45F));
		txtAmt.setPreferredSize(new Dimension(152, 20));
		txtAmt.setHorizontalAlignment(JTextField.TRAILING);
		
		JTextField txtSDate = new JTextField(16);
		txtSDate.setPreferredSize(new Dimension(155, 30));
		
		ImageIcon image1 = new ImageIcon("images/depositlbls.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(220, 59));
		
		ImageIcon image2 = new ImageIcon("images/dcheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(518, 60));
		
		//Make Menu buttons
		JButton adButton = new JButton ("A. Details"); 
		JButton pbButton = new JButton ("Pay Bills"); 
		JButton tfButton = new JButton ("T. Funds"); 
		JButton dcButton = new JButton ("D. Check"); 
		JButton upButton = new JButton ("U. Profile"); 
		JButton loButton = new JButton ("Logout"); 
		
		BufferedImage buttonIcon = ImageIO.read(new File("images/btnad.png"));
		adButton = new JButton(new ImageIcon(buttonIcon));
		adButton.setPreferredSize(new Dimension(88, 46));
		adButton.setBorderPainted(false);
		adButton.setFocusPainted(false);
		adButton.setContentAreaFilled(false);
		
		//Add listener to Account Details button
		adButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				try {
					new AccountDetailsWindow(customerindex);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}});	
		}});
		
		//Create Account Details button
		BufferedImage buttonIcon1 = ImageIO.read(new File("images/btnpb.png"));
		pbButton = new JButton(new ImageIcon(buttonIcon1));
		pbButton.setPreferredSize(new Dimension(88, 46));
		pbButton.setBorderPainted(false);
		pbButton.setFocusPainted(false);
		pbButton.setContentAreaFilled(false);
		
		//Add listener to Account Details button
		pbButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
					try {
						new PayBillsWindow(customerindex);
					} catch (ParseException | IOException e) {
						e.printStackTrace();
					}
			}});	
		}});
		
		//Create Transfer Funds button
		BufferedImage buttonIcon2 = ImageIO.read(new File("images/btntf.png"));
		tfButton = new JButton(new ImageIcon(buttonIcon2));
		tfButton.setPreferredSize(new Dimension(88, 46));
		tfButton.setBorderPainted(false);
		tfButton.setFocusPainted(false);
		tfButton.setContentAreaFilled(false);
		
		//Add listener to Transfer Funds button
		tfButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				try {
					new TransferFundsWindow(customerindex);
				} catch (ParseException | IOException e) {
					e.printStackTrace();
				}
			}});	
		}});
		
		//Create Deposit Check button
		BufferedImage buttonIcon3 = ImageIO.read(new File("images/btndc.png"));
		dcButton = new JButton(new ImageIcon(buttonIcon3));
		dcButton.setPreferredSize(new Dimension(88, 46));
		dcButton.setBorderPainted(false);
		dcButton.setFocusPainted(false);
		dcButton.setContentAreaFilled(false);
		
		//Add listener to Deposit Check button
		dcButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				try {
					new DepositCheckWindow(customerindex);
				} catch (ParseException | IOException e) {
					e.printStackTrace();
				}
			}});	
		}});
		
		//Create Update Profile button
		BufferedImage buttonIcon4 = ImageIO.read(new File("images/btnup.png"));
		upButton = new JButton(new ImageIcon(buttonIcon4));
		upButton.setPreferredSize(new Dimension(88, 46));
		upButton.setBorderPainted(false);
		upButton.setFocusPainted(false);
		upButton.setContentAreaFilled(false);
		
		//Add listener to Account Details button
		upButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				try {
					new UpdateProfileWindow(customerindex);
				} catch (ParseException | IOException e) {
					e.printStackTrace();
				}
			}});	
		}});
		
		//Create a Logout button
		BufferedImage buttonIcon5 = ImageIO.read(new File("images/btnlo.png"));
		loButton = new JButton(new ImageIcon(buttonIcon5));
		loButton.setPreferredSize(new Dimension(78, 46));
		loButton.setBorderPainted(false);
		loButton.setFocusPainted(false);
		loButton.setContentAreaFilled(false);
		
		// Add Listener to Logout button
		loButton.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e){
			System.exit(0);
			}});
		
		//Create Make Deposit button
		JButton depositButton = new JButton ("Make Deposit"); 
		depositButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		depositButton.setOpaque(false);
		depositButton.setPreferredSize(new Dimension(85, 22));
		depositButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon6 = ImageIO.read(new File("images/depositbtn.png"));
		depositButton = new JButton(new ImageIcon(buttonIcon6));
		depositButton.setBorderPainted(false);
		depositButton.setFocusPainted(false);
		depositButton.setContentAreaFilled(false);
		
		// Add Listener to Make Deposit button
		depositButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			// Retrieve the value from the text field
		    checkAmount = (Double) txtAmt.getValue();
		    
			//checkAmount = Double.parseDouble(txtAmt.getText());
			
			
			//DEPOSIT TO CHECKING ACCOUNT
			if (toList.getSelectedItem().toString().equals("Checking Account")){
				DTChecking += checkAmount;
				JOptionPane.showMessageDialog(null,"You have successfully deposited " + checkAmount+" to your Checking Account.");			
				}
				
			//DEPOSIT TO SAVINGS ACCOUNT
			else if (toList.getSelectedItem().toString().equals("Savings Account")){
				DTSavings += checkAmount;
				JOptionPane.showMessageDialog(null,"You have successfully deposited $" + checkAmount+" to your Savings Account.");
				}
			
			//DEPOSIT TO SOAR ACCOUNT
			 else if (toList.getSelectedItem().toString().equals("Soar Account")){
				DTSoar += checkAmount;
				JOptionPane.showMessageDialog(null,"You have successfully deposited $" + checkAmount+" to your Soar Account.");
			 	}
			
			try {
				calculateBalances(customerindex);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtAmt.setText("");
			
		}});
		
		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblCheck);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(toList);
        panel.add(txtAmt);
        panel.add(lblSelect);
        panel.add(lblBody);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(pbButton);
        panel.add(tfButton);
        panel.add(dcButton);
        panel.add(upButton);
        panel.add(loButton);
        panel.add(depositButton);
		
		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblCheck, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblCheck, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, toList, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, toList, 207,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtAmt, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtAmt, 237,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSDate, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSDate, 267,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 207, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHeader, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHeader, -1, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, adButton, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, adButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, pbButton, 88,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, pbButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, tfButton, 176,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, tfButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, dcButton, 264,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, dcButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, upButton, 352,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, upButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, loButton, 440,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, loButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, depositButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, depositButton, 330, SpringLayout.NORTH, panel);
}
	
	//Calculate new account balances
	void calculateBalances(int customerindex) throws IOException
	{ 
		//Calculate newCB - new Savings Account Balance
	 	newCB = LoadData.accounts[customerindex].getCheckingAcctBal() + DTChecking;
	 	
	 	//Calculate newSB - new Savings Account Balance
	 	newSB = LoadData.accounts[customerindex].getSavingsAcctBal() + DTSavings;
	 	
	 	//Calculate new SoB - new Soar Account Balance
	 	newSoB = LoadData.accounts[customerindex].getSoarAcctBal() + DTSoar;
	 	
	 	//Call methods
	 	depositFunds(customerindex);
	 	saveTransaction();	
	}
		
	//Update account balances
	boolean depositFunds(int customerindex){
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Bank11.mdb");
			Statement stmt = conn.createStatement();
			System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblAccount SET checkingAcctBal = '" +newCB+ "', savingsAcctBal = '" +newSB+ "', soarAcctBal = '" +newSoB+ "' WHERE custID = '" +LoadData.accounts[i].getCustID()+ "'";
			stmt.execute(upProfile);
			
			conn.close();
			JOptionPane.showMessageDialog(null, "Accounts table updated successfully");
		}
		catch( Exception e ){
			System.out.println("Can't retrieve from database connection: "+e);
		}
		return true;
	}
	
	//Write to the transaction table
	void saveTransaction(){
		try
		{
			int transCount = 0;
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///Volumes/GREEN GRASS/JSProject/prjTIMS_JS/Bank11.mdb");
			Statement stmt = conn.createStatement();
			System.out.println("Connected database successfully ...");
			
			String inTransaction = "insert into tblTransaction (transCount,"+ "custID,"+ "transNum," + "transType, "+ "transDate) "+ "values('"+transCount+"','"+ LoadData.accounts[i].getCustID()+"','"+transNum+"','"+transType+"','"+ts+"')"; 
			
			//i++;
			transCount++;
			stmt.execute(inTransaction);
			conn.close();
			JOptionPane.showMessageDialog(null, "Transaction table values inserted successfully");
		}
		catch( Exception e ){
			System.out.println("Can't retrieve from database connection: "+e);
		}
	}
}
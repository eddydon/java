package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class PayBillsWindow extends JFrame {

		public static int i = 0;
		public boolean match = false;
		
		double PFChecking, newCB, NnewCB, upMPB, upCCPB, newMPB, newCCPB;
		double mortAmount, creditAmount;
		
		int transNum = 1;
		String transType = "Payment";
		
		//Get current date time
		java.util.Date date = new java.util.Date(); 
		Timestamp ts = new Timestamp(date.getTime()); 
	
	PayBillsWindow(int customerindex) throws IOException, ParseException{
		
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon payment = new ImageIcon("images/payment.png");
		JLabel lblPayment = new JLabel(payment);
		lblPayment.setPreferredSize(new Dimension(48, 48));
		
		//Set date to be shown on window
		DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy"); //h:mm a
		Calendar cal = Calendar.getInstance();
		JLabel lblDate = new JLabel(dateFormat.format(cal.getTime()));
		lblDate.setFont(new Font("Helvetica", Font.BOLD, 10));
		lblDate.setForeground(new Color(251, 251, 251));
		
	    //Add the panel to the content page
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblHello = new JLabel("Hello, "+LoadData.people[customerindex].getTitle()+". "+LoadData.people[customerindex].getlName()+".");
		lblHello.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblHello.setForeground(new Color(251, 125, 24));
		
		JTextField checkPay = new JTextField("Checking Account");
		checkPay.setFont(new Font("Helvetica", Font.PLAIN, 12));
		checkPay.setPreferredSize(new Dimension(130, 20));
		checkPay.setEnabled(false);
		//checkPay.setForeground(new Color(251, 125, 24));
		
		JLabel lblSelect = new JLabel("Select transfer accounts and enter transfer amount below.");
		lblSelect.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblSelect.setForeground(new Color(251, 125, 24));
		
		ImageIcon image3 = new ImageIcon("images/paymentlbls.png");
		JLabel lblLabels = new JLabel(image3);
		lblLabels.setPreferredSize(new Dimension(227, 147));

		JLabel lblMAcct = new JLabel(""+LoadData.accounts[customerindex].getMortgageAcctNum());
		JLabel lblLoanDate = new JLabel(LoadData.mortgage[customerindex].getMloanDate());
		JLabel lblTotalPay = new JLabel("$"+LoadData.mortgage[customerindex].getTotalPayments());
		JLabel lblMonthPay = new JLabel("$"+LoadData.mortgage[customerindex].getMortMonthlyPayment());

		JLabel lblCCAcct = new JLabel(""+LoadData.accounts[customerindex].getCreditCardAcctNum());
		JLabel lblCreditDate = new JLabel(LoadData.credit[customerindex].getLoanDate());
		JLabel lblTotalCPay = new JLabel("$"+LoadData.credit[customerindex].getBalance());
		JLabel lblMonthCPay = new JLabel("$"+LoadData.credit[customerindex].getCcMonthlyPayment());

		lblCCAcct.setVisible(false);
		lblCreditDate.setVisible(false);
		lblTotalCPay.setVisible(false);
		lblMonthCPay.setVisible(false);
		
		JTextField txtSDate = new JTextField(16);
		txtSDate.setPreferredSize(new Dimension(85, 20));
		
		ImageIcon image1 = new ImageIcon("images/tlabels.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(259, 122));
		
		ImageIcon image2 = new ImageIcon("images/pbheader.png");
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
		
		JRadioButton mortgageButton = new JRadioButton("Pay Mortgage", true);
		mortgageButton.setMnemonic(KeyEvent.VK_M);
		mortgageButton.setActionCommand("Mortgage");
		mortgageButton.setFont(new Font("Helvetica", Font.BOLD, 11));
		mortgageButton.setOpaque(true);
		mortgageButton.setPreferredSize(new Dimension(130, 22));
		mortgageButton.setForeground(new Color(251, 125, 24));
		mortgageButton.setBackground(new Color(255, 255, 255));
		
		//Add listeners to Radio Buttons
		mortgageButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			//Execute when button is selected
			if (mortgageButton.isSelected())
			{
				lblMAcct.setVisible(true);
				lblLoanDate.setVisible(true);
				lblTotalPay.setVisible(true);
				lblMonthPay.setVisible(true);
				
				lblCCAcct.setVisible(false);
				lblCreditDate.setVisible(false);
				lblTotalCPay.setVisible(false);
				lblMonthCPay.setVisible(false);
			}
		}});
		 
		JRadioButton creditButton = new JRadioButton("Pay Credit Card", true);
		creditButton.setMnemonic(KeyEvent.VK_C);
		creditButton.setActionCommand("Credit");
		creditButton.setFont(new Font("Helvetica", Font.BOLD, 11));
		creditButton.setOpaque(true);
		creditButton.setPreferredSize(new Dimension(150, 22));
		creditButton.setForeground(new Color(251, 125, 24));
		creditButton.setBackground(new Color(255, 255, 255));

		//Add listeners to Radio Buttons
		creditButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			//Execute when button is selected
			if (creditButton.isSelected())
			{
				lblMAcct.setVisible(false);
				lblLoanDate.setVisible(false);
				lblTotalPay.setVisible(false);
				lblMonthPay.setVisible(false);
				
				lblCCAcct.setVisible(true);
				lblCreditDate.setVisible(true);
				lblTotalCPay.setVisible(true);
				lblMonthCPay.setVisible(true);
			}			
		}});
		
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(mortgageButton);
		bG.add(creditButton);
		
		//Make buttons
		JButton paymentButton = new JButton ("Pay now"); 
		paymentButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		paymentButton.setOpaque(false);
		paymentButton.setPreferredSize(new Dimension(85, 22));
		paymentButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon9 = ImageIO.read(new File("images/paymentbtn.png"));
		paymentButton = new JButton(new ImageIcon(buttonIcon9));
		paymentButton.setBorderPainted(false);
		paymentButton.setFocusPainted(false);
		paymentButton.setContentAreaFilled(false);

		paymentButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){

			//Pay from CHECKING ACCOUNT
			if (creditButton.isSelected()){
				creditAmount = LoadData.credit[customerindex].getCcMonthlyPayment();
				JOptionPane.showMessageDialog(null,"You have made a payment of " + creditAmount+" from your Checking Account.");
				}
				
			//Pay from SAVINGS ACCOUNT
			else if (mortgageButton.isSelected()){
				mortAmount = LoadData.mortgage[customerindex].getMortMonthlyPayment();
				JOptionPane.showMessageDialog(null,"You have made a payment of $" + mortAmount+" from your Checking Account.");
				}

			try {
				calculateBalances(customerindex);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}});

		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblPayment);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(mortgageButton);
        panel.add(creditButton);
        panel.add(lblSelect);
        panel.add(lblMAcct);
        panel.add(lblLoanDate);
        panel.add(lblTotalPay);
        panel.add(lblMonthPay);
        panel.add(lblCCAcct);
        panel.add(lblCreditDate);
        panel.add(lblTotalCPay);
        panel.add(lblMonthCPay);
        panel.add(lblLabels);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(pbButton);
        panel.add(tfButton);
        panel.add(dcButton);
        panel.add(upButton);
        panel.add(loButton);
        panel.add(paymentButton);
        panel.add(checkPay);

		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblPayment, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblPayment, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblLabels, 0, SpringLayout.WEST, panel);  //right
        layout.putConstraint(SpringLayout.NORTH, lblLabels, 240, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblMAcct, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblMAcct, 247, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblLoanDate, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblLoanDate, 277, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblTotalPay, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblTotalPay, 307, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblMonthPay, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblMonthPay, 337, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCCAcct, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCCAcct, 247, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCreditDate, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCreditDate, 277, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblTotalCPay, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblTotalCPay, 307, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblMonthCPay, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblMonthCPay, 337, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, mortgageButton, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mortgageButton, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, creditButton, 270, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, creditButton, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkPay, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkPay, 367,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSDate, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSDate, 291,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 193, SpringLayout.NORTH, panel);  //top
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
        layout.putConstraint(SpringLayout.WEST, paymentButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, paymentButton, 430, SpringLayout.NORTH, panel);
}

	//CALCULATE NEW BALANCES
	void calculateBalances(int customerindex) throws IOException
	{ 
		//CALCULATE ACCOUNT BALANCES
	 	newCB = LoadData.accounts[customerindex].getCheckingAcctBal() - creditAmount;
	 	NnewCB = newCB - mortAmount;
	 	newCCPB = LoadData.credit[customerindex].getBalance() - creditAmount;
	 	newMPB = LoadData.mortgage[customerindex].getTotalPayments() - mortAmount;
	 	
	 	displayPayment(customerindex);
	 	updateCCBalance(customerindex);
	 	updateMortBalance(customerindex);
	 	saveTransaction();	
	}
			
	private void updateMortBalance(int customerindex) {
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///Volumes/GREEN GRASS/JSProject/prjTIMS_JS/Bank11.mdb");
			Statement stmt = conn.createStatement();
			//System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblMortgage SET totalPayments = '" +newMPB+ "' WHERE custID = '" +LoadData.mortgage[i].getCustID()+ "'";
			stmt.execute(upProfile);
			
			conn.close();
			JOptionPane.showMessageDialog(null, "Mortgage table updated successfully");
		}
		catch( Exception e ){
			System.out.println("Can't retrieve from database connection: "+e);
		}
	}

	private void updateCCBalance(int customerindex) {
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///Volumes/GREEN GRASS/JSProject/prjTIMS_JS/Bank11.mdb");
			Statement stmt = conn.createStatement();
			//System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblCreditCard SET balance = '" +newCCPB+ "' WHERE custID = '" +LoadData.credit[i].getCustID()+ "'";
			stmt.execute(upProfile);
			
			conn.close();
			JOptionPane.showMessageDialog(null, "Credit Card table updated successfully");
		}
		catch( Exception e ){
			System.out.println("Can't retrieve from database connection: "+e);
		}
	}

	boolean displayPayment(int customerindex){
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess:///Volumes/GREEN GRASS/JSProject/prjTIMS_JS/Bank11.mdb");
			Statement stmt = conn.createStatement();
			//System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblAccount SET checkingAcctBal = '" +newCB+ "' WHERE custID = '" +LoadData.accounts[i].getCustID()+ "'";
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
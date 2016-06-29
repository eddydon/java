package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class WithdrawFundsWindow extends JFrame{

		public static int i = 0;
		
		double WFChecking, WFSavings, newCB, newSB, newSoB;
		double withdrawAmount;
		
		int transNum = 5;
		String transType = "Withdraw";
		
		//Get current date time
		java.util.Date date = new java.util.Date(); 
		Timestamp ts = new Timestamp(date.getTime()); 
	
	WithdrawFundsWindow(int customerindex) throws IOException, ParseException{
		
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon visa = new ImageIcon("images/wallet.png");
		JLabel lblVisa = new JLabel(visa);
		lblVisa.setPreferredSize(new Dimension(48, 48));
		
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
		
		JLabel lblSelect = new JLabel("Select transfer accounts and enter transfer amount below.");
		lblSelect.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblSelect.setForeground(new Color(251, 125, 24));
		
		// create a combo box with items specified in the String array:
		String[] transferFrom = new String[] { "Checking Account", "Savings Account" };
		final JComboBox<String> fromList = new JComboBox<String>(transferFrom);

		// customize some appearance:
		fromList.setFont(new Font("Helvetica", Font.PLAIN, 12));
		fromList.setMaximumRowCount(2);
		fromList.setBackground(new Color(255, 255, 255));
		
		// make the combo box editable so we can add new item when needed
		fromList.setEditable(false);
		
		JFormattedTextField txtAmt = new JFormattedTextField(new DecimalFormat("#.00"));
	    txtAmt.setValue(new Double(123.45F));
		txtAmt.setPreferredSize(new Dimension(152, 20));
		txtAmt.setHorizontalAlignment(JTextField.TRAILING);

		JTextField txtSDate = new JTextField(16);
		txtSDate.setPreferredSize(new Dimension(155, 30));
		
		ImageIcon image3 = new ImageIcon("images/withdrawlbls.png");
		JLabel lblWithdraw = new JLabel(image3);
		lblWithdraw.setPreferredSize(new Dimension(123, 53));
		
		ImageIcon image1 = new ImageIcon("images/lbllcwf.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(89, 153));
		
		ImageIcon image2 = new ImageIcon("images/wfheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(529, 59));
		
		//Make buttons
		JButton withdrawButton = new JButton ("Make Withdrawal"); 
		withdrawButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		withdrawButton.setOpaque(false);
		withdrawButton.setPreferredSize(new Dimension(85, 22));
		withdrawButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon6 = ImageIO.read(new File("images/withdrawbtn.png"));
		withdrawButton = new JButton(new ImageIcon(buttonIcon6));
		withdrawButton.setBorderPainted(false);
		withdrawButton.setFocusPainted(false);
		withdrawButton.setContentAreaFilled(false);
		
		withdrawButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			withdrawAmount = Double.parseDouble(txtAmt.getText());
			//Withdraw from CHECKING ACCOUNT
			if (fromList.getSelectedItem().toString().equals("Checking Account")){
				WFChecking -= withdrawAmount;
				JOptionPane.showMessageDialog(null,"You have successfully withdrawn " + withdrawAmount+" to your Checking Account.");
				}
				
			//Withdraw from SAVINGS ACCOUNT
			else if (fromList.getSelectedItem().toString().equals("Savings Account")){
				 WFSavings -= withdrawAmount;
				JOptionPane.showMessageDialog(null,"You have successfully withdrawn $" + withdrawAmount+" to your Savings Account.");
				}
			if	(withdrawAmount < 0  &&  withdrawAmount > 300){
				JOptionPane.showMessageDialog(null,"We're sorry, you are only authorized to withdraw a maximum amount of $300.00. Transaction Cancelled.");
				return;
				}

				//If transfer amount is more than balance amount, 
			if	(LoadData.accounts[customerindex].getCheckingAcctBal() < withdrawAmount && LoadData.accounts[customerindex].getSavingsAcctBal() < withdrawAmount){
				JOptionPane.showMessageDialog(null,"We're sorry, you do not have sufficient funds to complete this transaction. Transaction Cancelled.");
					return;
					 
					}
			
			try {
				calculateBalances(customerindex);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			//LoadData.accounts(customerindex);
			
		}});
		
		//Make buttons
		JButton adButton = new JButton ("A. Details"); 
		JButton wfButton = new JButton ("W. Funds"); 
		JButton cbButton = new JButton ("C. Bank"); 
		JButton loButton = new JButton ("Logout"); 
		
		BufferedImage buttonIcon = ImageIO.read(new File("images/btnlcad.png"));
		adButton = new JButton(new ImageIcon(buttonIcon));
		adButton.setPreferredSize(new Dimension(149, 44));
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
					new LCAccountDetailsWindow(customerindex);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}});	
		}});
		
		BufferedImage buttonIcon2 = ImageIO.read(new File("images/btnlclwf.png"));
		wfButton = new JButton(new ImageIcon(buttonIcon2));
		wfButton.setPreferredSize(new Dimension(144, 44));
		wfButton.setBorderPainted(false);
		wfButton.setFocusPainted(false);
		wfButton.setContentAreaFilled(false);
		
		//Add listener to Transfer Funds button
		wfButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				
					try {
						new WithdrawFundsWindow(customerindex);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ParseException e) {
						e.printStackTrace();
					}
			}});	
		}});
		
		BufferedImage buttonIcon3 = ImageIO.read(new File("images/btnlccb.png"));
		cbButton = new JButton(new ImageIcon(buttonIcon3));
		cbButton.setPreferredSize(new Dimension(122, 44));
		cbButton.setBorderPainted(false);
		cbButton.setFocusPainted(false);
		cbButton.setContentAreaFilled(false);
		
		//Add listener to Deposit Check button
		cbButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				
						try {
							new ContactBankWindow(customerindex);
						} catch (IOException e) {
							e.printStackTrace();
						} catch (ParseException e) {
							e.printStackTrace();
						}
				
			}});	
		}});
		
		BufferedImage buttonIcon5 = ImageIO.read(new File("images/btnlclo.png"));
		loButton = new JButton(new ImageIcon(buttonIcon5));
		loButton.setPreferredSize(new Dimension(115, 44));
		loButton.setBorderPainted(false);
		loButton.setFocusPainted(false);
		loButton.setContentAreaFilled(false);
		
		// Add Listener to Logout button
		loButton.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e){
			System.exit(0);
			}});
		
		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblVisa);
        panel.add(lblWithdraw);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(wfButton);
        panel.add(cbButton);
        panel.add(loButton);
        panel.add(fromList);
        panel.add(txtAmt);
        panel.add(lblSelect);
        panel.add(withdrawButton);
        
		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblVisa, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblVisa, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblWithdraw, 100,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblWithdraw, 235, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 150, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHeader, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHeader, 0, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, adButton, -9,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, adButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, wfButton, 139,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, wfButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, cbButton, 283,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, cbButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, loButton, 404,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, loButton, 58, SpringLayout.NORTH, panel);  //top
        
        layout.putConstraint(SpringLayout.WEST, fromList, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fromList, 235,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtAmt, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtAmt, 266,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSDate, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSDate, 291,  SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 139, SpringLayout.NORTH, panel);  //top
        
        layout.putConstraint(SpringLayout.WEST, withdrawButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, withdrawButton, 330, SpringLayout.NORTH, panel);
	}
	
	
	//CALCULATE NEW BALANCES
	void calculateBalances(int customerindex) throws IOException
	{ 
		//CALCULATE ACCOUNT BALANCES
	 	newCB = LoadData.accounts[customerindex].getCheckingAcctBal() + WFChecking;
	 	
	 	//Calculate newSB - new Savings Account Balance
	 	newSB = LoadData.accounts[customerindex].getSavingsAcctBal() + WFSavings;

	 	withdrawFunds(customerindex);
	 	saveTransaction();	
	}
			
	boolean withdrawFunds(int customerindex){
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Bank11.mdb");
			Statement stmt = conn.createStatement();
			System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblAccount SET checkingAcctBal = '" +newCB+ "', savingsAcctBal = '" +newSB+ "' WHERE custID = '" +LoadData.accounts[i].getCustID()+ "'";
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
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Bank11.mdb");
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
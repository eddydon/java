package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TransferFundsWindow extends JFrame{
	
		public static int i = 0;
		
		double TSoA, FCA, TCA, FSA, TSA, newCB, newSB, newSoB;
		double transferAmount;
		
		int transNum = 3;
		String transType = "Transfer";
		
		//Get current date time
		java.util.Date date = new java.util.Date(); 
		Timestamp ts = new Timestamp(date.getTime()); 

	TransferFundsWindow(int customerindex) throws IOException, ParseException{

		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon transfer = new ImageIcon("images/transfer.png");
		JLabel lblTransfer = new JLabel(transfer);
		lblTransfer.setPreferredSize(new Dimension(48, 48));
		
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
		fromList.setSelectedItem("Checking Account");
		//fromList.setEnabled(false);
		
		// make the combo box editable so we can add new item when needed
		fromList.setEditable(false);
		
		// create a combo box with items specified in the String array:
		String[] transferTo = new String[] { "Checking Account", "Savings Account", "Soar Account" };
		final JComboBox<String> toList = new JComboBox<String>(transferTo);

		// customize some appearance:
		toList.setFont(new Font("Helvetica", Font.PLAIN, 12));
		toList.setMaximumRowCount(3);
		toList.setBackground(new Color(255, 255, 255));
		toList.setSelectedItem("Savings Account");
		toList.setEnabled(false);
		
		// make the combo box editable so we can add new item when needed
		toList.setEditable(false);

		fromList.addActionListener( new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    //if(e.getSource() == fromList){
	       if (fromList.getSelectedItem().equals("Checking Account")){
	    	   toList.setEnabled(true);
	    	   toList.setSelectedItem("Savings Account");
	    	   }
	       
	       else if (fromList.getSelectedItem().equals("Savings Account")){
	    	   toList.repaint();
	    	   toList.setEnabled(true);
	    	   toList.setSelectedItem("Checking Account");
	       }
	    }});
		
		
		JFormattedTextField txtAmt = new JFormattedTextField(new DecimalFormat("#.00"));
	    txtAmt.setValue(new Double(123.45F));
		txtAmt.setPreferredSize(new Dimension(152, 20));
		txtAmt.setHorizontalAlignment(JTextField.TRAILING);
		
		JTextField txtSDate = new JTextField(16);
		txtSDate.setPreferredSize(new Dimension(155, 30));
		
		ImageIcon image1 = new ImageIcon("images/tflabel.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(133, 81));
		
		ImageIcon image2 = new ImageIcon("images/tfheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(518, 60));
		
		//Make buttons
		JButton adButton = new JButton ("A. Details"); 
		JButton pbButton = new JButton ("Pay Bills"); 
		JButton tfButton = new JButton ("T. Funds"); 
		JButton dcButton = new JButton ("D. Check"); 
		JButton upButton = new JButton ("U. Profile"); 
		JButton loButton = new JButton ("Logout"); 
		
		//Make buttons
		JButton transferButton = new JButton ("Make Transfer"); 
		transferButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		transferButton.setOpaque(false);
		transferButton.setPreferredSize(new Dimension(85, 22));
		transferButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon6 = ImageIO.read(new File("images/transferbt.png"));
		transferButton = new JButton(new ImageIcon(buttonIcon6));
		transferButton.setBorderPainted(false);
		transferButton.setFocusPainted(false);
		transferButton.setContentAreaFilled(false);
		
		//Add listener to Account Details button
		transferButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			transferAmount = Double.parseDouble(txtAmt.getText());
			int amount = Integer.parseInt(txtAmt.getText());
			if (amount == 0){
				JOptionPane.showMessageDialog(null, "Amount is missing! Try Again!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
				//return();
			if (fromList.getSelectedItem().toString().equals("Checking Account") && toList.getSelectedItem().toString().equals("Checking Account")){
				JOptionPane.showMessageDialog(null, "You cannot transfer to the same account. Try Again!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
		    	   }
			else if (fromList.getSelectedItem().toString().equals("Savings Account") && toList.getSelectedItem().toString().equals("Savings Account")){
				JOptionPane.showMessageDialog(null, "You cannot transfer to the same account. Try Again!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
	    	   }
			else if (fromList.getSelectedItem().toString().equals("Savings Account") && toList.getSelectedItem().toString().equals("Checking Account")){
				FSA =- transferAmount;
				TCA =+ transferAmount;
				JOptionPane.showMessageDialog(null, "Your transfer of $" +transferAmount+ " was successfully transfered to your Checking Account!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
	    	   }
			else if (fromList.getSelectedItem().toString().equals("Savings Account") && toList.getSelectedItem().toString().equals("Soar Account")){
				FSA =- transferAmount;
				TSoA =+ transferAmount;
				JOptionPane.showMessageDialog(null, "Your transfer of $" +transferAmount+ " was successfully transfered to your Soar Account!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
	    	   }
			else if (fromList.getSelectedItem().toString().equals("Checking Account") && toList.getSelectedItem().toString().equals("Savings Account")){
				FCA -= transferAmount;
				TSA += transferAmount;
				JOptionPane.showMessageDialog(null, "Your transfer of $" +transferAmount+ " was successfully transfered to your Savings Account!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
	    	   }
			else if (fromList.getSelectedItem().toString().equals("Checking Account") && toList.getSelectedItem().toString().equals("Soar Account")){
				FCA =- transferAmount;
				TSoA =+ transferAmount;
				JOptionPane.showMessageDialog(null, "Your transfer of $" +transferAmount+ " was successfully transfered to your Soar Account!", "Jo's Dealership: Warning",JOptionPane.WARNING_MESSAGE);
	    	   }
			}
		}});
		
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
			}});	
		}});
		
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});	
		}});
		
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}});	
				}});
		
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}});	
				}});
		
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

		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblTransfer);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(fromList);
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
        panel.add(transferButton);
		
		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblTransfer, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblTransfer, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, fromList, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fromList, 207,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, toList, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, toList, 235,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtAmt, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtAmt, 266,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSDate, 253,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSDate, 291,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblBody, 90,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 205, SpringLayout.NORTH, panel);  //top
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
        layout.putConstraint(SpringLayout.WEST, transferButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, transferButton, 330, SpringLayout.NORTH, panel);
}
	
	//CALCULATE NEW BALANCES
	void calculateBalances(int customerindex) throws IOException
	{ 
		//CALCULATE ACCOUNT BALANCES
	 	newCB = LoadData.accounts[customerindex].getCheckingAcctBal() + FCA + TCA;
	 	
	 	//Calculate newSB - new Savings Account Balance
	 	newSB = LoadData.accounts[customerindex].getSavingsAcctBal() + FSA + TSA;
	 	
	 	//Calculate new SoB - new Soar Account Balance
	 	newSoB = LoadData.accounts[customerindex].getSoarAcctBal() + TSoA;
		
	 	transferFunds(customerindex);
	 	saveTransaction();	
	}
	
	boolean transferFunds(int customerindex){
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
package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.*;
import java.util.Calendar;

import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AccountDetailsWindow extends JFrame {

	public AccountDetailsWindow(int customerindex) throws IOException{

		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon dollar = new ImageIcon("images/dollar.png");
		JLabel lblDollar = new JLabel(dollar);
		lblDollar.setPreferredSize(new Dimension(48, 48));
		
		//Set date to be shown on window
		DateFormat dateFormat = new SimpleDateFormat("MMMMM d, yyyy"); //h:mm a
		Calendar cal = Calendar.getInstance();
		JLabel lblDate = new JLabel(dateFormat.format(cal.getTime()));
		lblDate.setFont(new Font("Helvetica", Font.BOLD, 10));
		lblDate.setForeground(new Color(251, 251, 251));
		
		//Create Welcome label
		JLabel lblHello = new JLabel("Hello, "+LoadData.people[customerindex].getTitle()+". "+LoadData.people[customerindex].getlName()+".");
		lblHello.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblHello.setForeground(new Color(251, 125, 24));
		
		//Load account balances
		JLabel lblCbal = new JLabel("$"+LoadData.accounts[customerindex].getCheckingAcctBal());
		lblCbal.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblSbal = new JLabel("$"+LoadData.accounts[customerindex].getSavingsAcctBal());
		lblSbal.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblSobal = new JLabel("$"+LoadData.accounts[customerindex].getSoarAcctBal());
		lblSobal.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblCCbal = new JLabel("$"+LoadData.credit[customerindex].getBalance());
		lblCCbal.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblMbal = new JLabel("$"+LoadData.mortgage[customerindex].getTotalPayments());
		lblMbal.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblCacct = new JLabel("#"+LoadData.accounts[customerindex].getCheckingAcctNum());
		lblCacct.setForeground(new Color(245, 135, 79));
		lblCacct.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblSacct = new JLabel("#"+LoadData.accounts[customerindex].getSavingsAcctNum());
		lblSacct.setForeground(new Color(245, 135, 79));
		lblSacct.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblSoacct = new JLabel("#"+LoadData.accounts[customerindex].getSoarAcctNum());
		lblSoacct.setForeground(new Color(245, 135, 79));
		lblSoacct.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblCCacct = new JLabel("#"+LoadData.accounts[customerindex].getCreditCardAcctNum());
		lblCCacct.setForeground(new Color(245, 135, 79));
		lblCCacct.setFont(new Font("Helvetica", Font.PLAIN, 11));
		JLabel lblMacct = new JLabel("#"+LoadData.accounts[customerindex].getMortgageAcctNum());
		lblMacct.setForeground(new Color(245, 135, 79));
		lblMacct.setFont(new Font("Helvetica", Font.PLAIN, 11));
		
		//Label images
		ImageIcon image1 = new ImageIcon("images/acbody.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(518, 352));
		
		//Label images
		ImageIcon image2 = new ImageIcon("images/acheader.png");
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
		
		//Add the panel to the content page
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(255, 255, 255));
		
		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblDollar);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(lblCbal);
        panel.add(lblSbal);
        panel.add(lblSobal);
        panel.add(lblCCbal);
        panel.add(lblMbal);
        panel.add(lblCacct);
        panel.add(lblSacct);
        panel.add(lblSoacct);
        panel.add(lblCCacct);
        panel.add(lblMacct);
        panel.add(lblBody);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(pbButton);
        panel.add(tfButton);
        panel.add(dcButton);
        panel.add(upButton);
        panel.add(loButton);
        
		
		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblDollar, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblDollar, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 102,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCacct, 174,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCacct, 239, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSacct, 164,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSacct, 256, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSoacct, 144,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSoacct, 272, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCCacct, 192,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCCacct, 345, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblMacct, 178,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblMacct, 417, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCbal, 344,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCbal, 239, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSbal, 344,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSbal, 256, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSobal, 344,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSobal, 272, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblCCbal, 344,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblCCbal, 345, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblMbal, 330,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblMbal, 417, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 150, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHeader, 0,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHeader, 0, SpringLayout.NORTH, panel);  //top
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
	}

}
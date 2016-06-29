package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.*;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LCAccountDetailsWindow extends JFrame{
	
	LCAccountDetailsWindow (int customerindex) throws IOException{
		
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
		
		JLabel lblHello = new JLabel("Hello, "+LoadData.people[customerindex].getTitle()+". "+LoadData.people[customerindex].getlName()+".");
		lblHello.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblHello.setForeground(new Color(251, 125, 24));
		
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
		
		ImageIcon image1 = new ImageIcon("images/acbody.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(518, 352));
		
		ImageIcon image2 = new ImageIcon("images/acheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(518, 60));
		
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
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
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
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
        panel.add(wfButton);
        panel.add(cbButton);
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
        layout.putConstraint(SpringLayout.WEST, adButton, -9,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, adButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, wfButton, 139,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, wfButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, cbButton, 283,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, cbButton, 58, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, loButton, 404,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, loButton, 58, SpringLayout.NORTH, panel);  //top
	}
}
package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ContactBankWindow extends JFrame {
	
	ContactBankWindow (int customerindex) throws IOException, ParseException{
		
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon contact = new ImageIcon("images/contact.png");
		JLabel lblContact = new JLabel(contact);
		lblContact.setPreferredSize(new Dimension(48, 48));
		
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
		
		//Welcome user
		JLabel lblHello = new JLabel("Hello, "+LoadData.people[customerindex].getTitle()+". "+LoadData.people[customerindex].getlName()+".");
		lblHello.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblHello.setForeground(new Color(251, 125, 24));
		
		//User message
		JLabel lblSelect = new JLabel("Select transfer accounts and enter transfer amount below.");
		lblSelect.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblSelect.setForeground(new Color(251, 125, 24));
		
		// Get customer's full name
		JLabel lblName = new JLabel(LoadData.people[customerindex].getTitle()+ ". " +LoadData.people[customerindex].getfName()+ " " +LoadData.people[customerindex].getlName());
		
		// Subject field
		JTextField txtSubject = new JTextField("Report Lost Card");
		txtSubject.setPreferredSize(new Dimension(150, 20));
		
		// Create text area for user input
		JTextArea txtMessage = new JTextArea("I lost my bank card. I need to request a replacement.");
		txtMessage.setPreferredSize(new Dimension(148, 120));
		txtMessage.setLineWrap(true);
		txtMessage.setRows(5);
		txtMessage.setWrapStyleWord(true);
		
		// Set border for text area
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		txtMessage.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(0, 0, 2, 2)));
		
		ImageIcon image1 = new ImageIcon("images/lbllcwf.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(89, 153));
		
		ImageIcon image2 = new ImageIcon("images/cbheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(529, 59));
		
		//Make Menu buttons
		JButton adButton = new JButton ("A. Details"); 
		JButton wfButton = new JButton ("W. Funds"); 
		JButton cbButton = new JButton ("C. Bank"); 
		JButton loButton = new JButton ("Logout"); 
		
		//Create Account Details button
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
		
		//Create Withdraw Funds button
		BufferedImage buttonIcon2 = ImageIO.read(new File("images/btnlclwf.png"));
		wfButton = new JButton(new ImageIcon(buttonIcon2));
		wfButton.setPreferredSize(new Dimension(144, 44));
		wfButton.setBorderPainted(false);
		wfButton.setFocusPainted(false);
		wfButton.setContentAreaFilled(false);
		
		//Add listener to Withdraw Funds button
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
		
		//Create Contact Bank button
		BufferedImage buttonIcon3 = ImageIO.read(new File("images/btnlccb.png"));
		cbButton = new JButton(new ImageIcon(buttonIcon3));
		cbButton.setPreferredSize(new Dimension(122, 44));
		cbButton.setBorderPainted(false);
		cbButton.setFocusPainted(false);
		cbButton.setContentAreaFilled(false);
		
		//Add listener to Contact Bankbutton
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
		
		// Create Logout button
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
		
		//Create Make Deposit button
		JButton contactButton = new JButton ("Contact Button"); 
		contactButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		contactButton.setOpaque(false);
		contactButton.setPreferredSize(new Dimension(85, 22));
		contactButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon6 = ImageIO.read(new File("images/contactbtn.png"));
		contactButton = new JButton(new ImageIcon(buttonIcon6));
		contactButton.setBorderPainted(false);
		contactButton.setFocusPainted(false);
		contactButton.setContentAreaFilled(false);
		
		// Add Listener to Make Deposit button
		contactButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){

			
		}});
		
		//Display the frame
		setVisible(true);
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
		
		//Add the components to the content pane
        panel.add(lblContact);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(lblBody);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(wfButton);
        panel.add(cbButton);
        panel.add(loButton);
        panel.add(lblName);
        panel.add(lblSelect);
        panel.add(txtSubject);
        panel.add(txtMessage);
        panel.add(contactButton);
        
		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblContact, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblContact, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblName, 235,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblName, 223, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtSubject, 233,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, txtSubject, 250, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtMessage, 235, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtMessage, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblBody, 135,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblBody, 218, SpringLayout.NORTH, panel);  //top
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
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, contactButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, contactButton, 455, SpringLayout.NORTH, panel);
		}

	}
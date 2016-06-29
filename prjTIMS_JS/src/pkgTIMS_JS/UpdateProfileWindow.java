package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class UpdateProfileWindow extends JFrame {

		public static int i = 0;
		public boolean match = false;
		
		String newpass;
		String conpass;
		String oldpass;
	
	UpdateProfileWindow(int customerindex) throws IOException, ParseException{
		
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
		
		//Give the frame an initial size and center the window
		setSize(518, 600);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon update = new ImageIcon("images/update.png");
		JLabel lblUpdate = new JLabel(update);
		lblUpdate.setPreferredSize(new Dimension(48, 48));
		
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
		
		ImageIcon image3 = new ImageIcon("images/updatelbls.png");
		JLabel lblLabels = new JLabel(image3);
		lblLabels.setPreferredSize(new Dimension(227, 147));
		
		ImageIcon image31 = new ImageIcon("images/passwordlbls.png");
		JLabel lblChangePwd = new JLabel(image31);
		lblChangePwd.setPreferredSize(new Dimension(227, 147));

		JPasswordField txtNewPwd = new JPasswordField(10);
		txtNewPwd.setPreferredSize(new Dimension(85, 20));
		txtNewPwd.setEnabled(false);
		txtNewPwd.setEchoChar('*');
		
		JPasswordField txtConPwd = new JPasswordField(10);
		txtConPwd.setPreferredSize(new Dimension(85, 20));
		txtConPwd.setEnabled(false);
		txtConPwd.setEchoChar('*');
		
		JPasswordField txtoldPwd = new JPasswordField(10);
		txtoldPwd.setPreferredSize(new Dimension(85, 20));
		txtoldPwd.setEnabled(false);
		txtoldPwd.setEchoChar('*');
		
		//Make buttons
		JButton updateButton = new JButton ("Pay now"); 
		updateButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		updateButton.setOpaque(false);
		updateButton.setPreferredSize(new Dimension(85, 22));
		updateButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon9 = ImageIO.read(new File("images/updatebtn.png"));
		updateButton = new JButton(new ImageIcon(buttonIcon9));
		updateButton.setBorderPainted(false);
		updateButton.setFocusPainted(false);
		updateButton.setContentAreaFilled(false);
		
		//Add listeners to Radio Buttons
		updateButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			//Execute when button is selected
			newpass = new String (txtNewPwd.getPassword());
			conpass = new String (txtConPwd.getPassword());
			oldpass = new String (txtoldPwd.getPassword());
	
	  		for (i = 0; i < LoadData.people.length; ++i)
			{	
				if (oldpass.equals(LoadData.people[customerindex].getPassword()) && newpass.equals(conpass))
	 				{	
	 					match = true;
	 				}
	 		}
	  		if (match)
	  		{
	  			updateProfile(customerindex);
				JOptionPane.showMessageDialog(null,"Password Changed!");
				JOptionPane.showMessageDialog(null,"You are being securely logged out. Please sign back in with your new password!");
				System.exit(0);
	  		}
	  		if (!match){
	  			JOptionPane.showMessageDialog(null,"Password doesnt match. Try again.");
	  		}		
		}});
		
		JLabel lblName = new JLabel(LoadData.people[customerindex].getTitle()+ ". " +LoadData.people[customerindex].getfName()+ " " +LoadData.people[customerindex].getlName());
		JLabel lblAddress = new JLabel(LoadData.people[customerindex].getHouseNum()+ " " +LoadData.people[customerindex].getStreetName()+", ");
		JLabel lblAddress1 = new JLabel(LoadData.people[customerindex].getCity()+ ", " +LoadData.people[customerindex].getState()+" " +LoadData.people[customerindex].getZipcode()+".");
		JLabel lblPhone = new JLabel(LoadData.people[customerindex].getPhoneNum());
		JLabel lblEmail = new JLabel(LoadData.people[customerindex].getEmail());
		
		JCheckBox changeButton = new JCheckBox("Change Password");
		changeButton.setMnemonic(KeyEvent.VK_C); 
		changeButton.setSelected(false);

		//Add listeners to Radio Buttons
		changeButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		//Execute when button is selected
		if (changeButton.isSelected())
		{							
			txtNewPwd.setEnabled(true);
			txtConPwd.setEnabled(true);
			txtoldPwd.setEnabled(true);
		}			
		}});
		
		ImageIcon image1 = new ImageIcon("images/tlabels.png");
		JLabel lblBody = new JLabel(image1);
		lblBody.setPreferredSize(new Dimension(259, 122));
		
		ImageIcon image2 = new ImageIcon("images/upheader.png");
		JLabel lblHeader = new JLabel(image2);
		lblHeader.setPreferredSize(new Dimension(518, 60));
		
		//Make buttons
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
        panel.add(lblUpdate);
        panel.add(lblDate);
        panel.add(lblHello);
        panel.add(lblSelect);
        panel.add(lblName);
        panel.add(lblAddress);
        panel.add(lblAddress1);
        panel.add(lblPhone);
        panel.add(lblEmail);
        panel.add(txtoldPwd);
        panel.add(txtNewPwd);
        panel.add(txtConPwd);
        panel.add(lblChangePwd);
        panel.add(changeButton);
        panel.add(lblLabels);
        panel.add(lblHeader);
        panel.add(adButton);
        panel.add(pbButton);
        panel.add(tfButton);
        panel.add(dcButton);
        panel.add(upButton);
        panel.add(loButton);
        panel.add(updateButton);

		//Adjust constraints for the components
        layout.putConstraint(SpringLayout.WEST, lblUpdate, 15, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblUpdate, 5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lblDate, 375,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblDate, 30, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblHello, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblHello, 139, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblSelect, 82,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 159, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblLabels, 65, SpringLayout.WEST, panel);  //right
        layout.putConstraint(SpringLayout.NORTH, lblLabels, 220, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblName, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblName, 217, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblAddress, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblAddress, 247, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblAddress1, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblAddress1, 277, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblPhone, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblPhone, 307, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblEmail, 253,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, lblEmail, 337, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, lblChangePwd, 55, SpringLayout.WEST, panel);  //right
        layout.putConstraint(SpringLayout.NORTH, lblChangePwd, 380, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtoldPwd, 263,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, txtoldPwd, 417, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtNewPwd, 263,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, txtNewPwd, 447, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtConPwd, 263,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, txtConPwd, 477, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, changeButton, 170,  SpringLayout.WEST, panel); //right
        layout.putConstraint(SpringLayout.NORTH, changeButton, 367, SpringLayout.NORTH, panel);  //top
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
        layout.putConstraint(SpringLayout.WEST, updateButton, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, updateButton, 517, SpringLayout.NORTH, panel);
}
	
	boolean updateProfile(int customerindex){
		int i = 0;
		try
		{
			//Connect to the database
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Bank.mdb");
			Statement stmt = conn.createStatement();
			System.out.println("Connected database successfully ...");
			
			String upProfile = "UPDATE tblCustomer SET password = '" +newpass+ "' WHERE username = '" +LoadData.people[i].getUsername()+ "'";
			stmt.execute(upProfile);
			
			conn.close();
			JOptionPane.showMessageDialog(null, "Customer table updated successfully");
		}
		catch( Exception e ){
			System.out.println("Can't retrieve from database connection: "+e);
		}
		return true;	
	}
}
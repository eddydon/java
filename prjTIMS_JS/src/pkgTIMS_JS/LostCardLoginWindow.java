package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LostCardLoginWindow extends JFrame {
		public static int customerindex = 0;
		public static int i = 0;
		public boolean found = false;	
		public int attempts = 1;
	
	LostCardLoginWindow() throws IOException  {
	
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		//setUndecorated(true);
	
		//Give the frame an initial size and center the window
		setSize(360, 300);
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon atm = new ImageIcon("images/persons.png");
		JLabel lblATM = new JLabel(atm);
		lblATM.setPreferredSize(new Dimension(48, 48));
	
		//Create header image label
		ImageIcon image1 = new ImageIcon("images/lclheader.png");
		JLabel lblHeader = new JLabel(image1);
		lblHeader.setPreferredSize(new Dimension(360, 108));
		
		//Create user labels
		ImageIcon image2 = new ImageIcon("images/lblslc.png");
		JLabel lblLabels = new JLabel(image2);
		lblLabels.setPreferredSize(new Dimension(153, 107));

		//Create uniqueID text field
		JPasswordField txtUniqueID = new JPasswordField(10);
		txtUniqueID.setPreferredSize(new Dimension(85, 20));
		txtUniqueID.setEchoChar('*');
		
		//Create sightKey text field
		JTextField txtSKey = new JTextField(10);
		txtSKey.setPreferredSize(new Dimension(85, 20));
		
		//Create SSN password field
		JPasswordField txtSSN = new JPasswordField(10);
		txtSSN.setPreferredSize(new Dimension(85, 20));
		txtSSN.setEchoChar('*');
		
		//Make Login button
		JButton loginButton = new JButton ("Login"); 
		loginButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		loginButton.setOpaque(false);
		loginButton.setPreferredSize(new Dimension(85, 22));
		loginButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon = ImageIO.read(new File("images/btnlc.png"));
		loginButton = new JButton(new ImageIcon(buttonIcon));
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		
		//Add listener to login button
		loginButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
			
			//Execute when button is pressed
			txtUniqueID.requestFocusInWindow();
			try{
			String typeduser = new String (txtUniqueID.getPassword());
			String typedkey = txtSKey.getText();
			int enteredpass = Integer.parseInt(txtSSN.getText());
		
			//Validate user's login information
			for (i = 0; i < LoadData.people.length; ++i){
				if (typeduser.equals(LoadData.people[i].getUniqueID()) && typedkey.equals(LoadData.people[i].getSightkey()) 
						&& enteredpass == LoadData.people[i].getSSN()){	
						found = true;
	 					customerindex = i;
	 					break;
					}
			}if (found){
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
				setVisible(false);
				try {
					new LCAccountDetailsWindow(customerindex);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
			
			}else if (attempts <= 4){
				JOptionPane.showMessageDialog(null,"Invalid Login. Attempts = " +attempts+". Try Again", "Golden Eagle Bank: Warning",JOptionPane.WARNING_MESSAGE);
				++attempts;
				
			}if (attempts == 4){
		  			JOptionPane.showMessageDialog(null,"You've tried three times. Bye", "Golden Eagle Bank: Warning",JOptionPane.WARNING_MESSAGE);
		  			System.exit(0);
			}
			}catch (NumberFormatException nfe){
				JOptionPane.showMessageDialog(null, "Information is Missing! Try Again!", "Golden Eagle Bank: Warning",JOptionPane.WARNING_MESSAGE);
				++attempts;
			
				
				if (attempts == 4){
		  			JOptionPane.showMessageDialog(null,"You've tried three times. Bye", "Golden Eagle Bank: Warning",JOptionPane.WARNING_MESSAGE);
		  			System.exit(0);
			}
			 }
		  }});
		
		//Add the panel to the content page
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(230, 146, 103));
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
	    panel.setLayout(layout);
		
		//Add the components to the content pane
	    panel.add(lblATM);
	    panel.add(lblHeader);
	    panel.add(lblLabels);
		panel.add(txtUniqueID);
		panel.add(txtSKey);
		panel.add(txtSSN);
		panel.add(loginButton);
		
		//Adjust constraints for the components
		layout.putConstraint(SpringLayout.WEST, lblATM, 5, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblATM, 10, SpringLayout.NORTH, panel); 
	    layout.putConstraint(SpringLayout.WEST, lblHeader, 0,  SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblHeader, 0, SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, lblLabels, 0, SpringLayout.WEST, panel);  //right
	    layout.putConstraint(SpringLayout.NORTH, lblLabels, 110, SpringLayout.NORTH, panel);  //top
        layout.putConstraint(SpringLayout.WEST, txtUniqueID, 150,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtUniqueID, 130,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSKey, 150,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSKey, 160,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtSSN, 150,  SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSSN, 190,  SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginButton, 95, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 220, SpringLayout.NORTH, panel);     
		
		//Display the frame
		setVisible(true);
		}
}
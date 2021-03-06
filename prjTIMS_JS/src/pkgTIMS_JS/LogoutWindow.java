package pkgTIMS_JS;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LogoutWindow extends JFrame {
	
	public static int customerindex = 0;
	public static int i = 0;
	public boolean found = false;	
	public int attempts = 1;
	
	public LogoutWindow() throws IOException  {
		
		//Create a new frame container
		setTitle("Golden Eagle Bank");
		
		//Hide the minimize, maximize and close buttons
		setUndecorated(true);
	
		//Give the frame an initial size and center the window
		setSize(518, 524);
		setLocationRelativeTo(null);
		
		//Set project icon
		ImageIcon image = new ImageIcon("images/.png");
		setIconImage(image.getImage());
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		ImageIcon image1 = new ImageIcon("images/login.png");
		JLabel lblHeader = new JLabel(image1);
		lblHeader.setPreferredSize(new Dimension(360, 120));
		
		ImageIcon image2 = new ImageIcon("images/loginlbls.png");
		JLabel lblLabels = new JLabel(image2);
		lblLabels.setPreferredSize(new Dimension(134, 87));
		
		// Create LostCard button
		JButton lostCardButton = new JButton ("Lost"); 
		lostCardButton.setFont(new Font("Helvetica", Font.BOLD, 10));
		lostCardButton.setOpaque(false);
		lostCardButton.setPreferredSize(new Dimension(90, 20));
		lostCardButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon5 = ImageIO.read(new File("images/lclbls.png"));
		lostCardButton = new JButton(new ImageIcon(buttonIcon5));
		lostCardButton.setBorderPainted(false);
		lostCardButton.setFocusPainted(false);
		lostCardButton.setContentAreaFilled(false);
		
		// Add action listener to LostCard button
		lostCardButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(false);
				try {
					new LostCardLoginWindow();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}});	
		}});

		// Create UserID field
		JTextField txtUserID = new JTextField(10);
		txtUserID.setPreferredSize(new Dimension(85, 20));
		
		// Create User password field
		JPasswordField txtPassword = new JPasswordField(10);
		txtPassword.setPreferredSize(new Dimension(85, 20));
		txtPassword.setEchoChar('*');
		
		// Make login button
		JButton loginButton = new JButton ("Login"); 
		loginButton.setFont(new Font("Helvetica", Font.BOLD, 12));
		loginButton.setOpaque(false);
		loginButton.setPreferredSize(new Dimension(85, 22));
		loginButton.setForeground(new Color(251, 125, 24));
		
		BufferedImage buttonIcon = ImageIO.read(new File("images/loginbt.png"));
		loginButton = new JButton(new ImageIcon(buttonIcon));
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		
		//int hi = LoadData.trans[customerindex].getCustID();
		//Add listener to Login button
		loginButton.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
	
		}});
		
		//Add the panel to the content page
		JPanel panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(255, 255, 255));
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
	    panel.setLayout(layout);
		
		//Add the components to the content pane
	    panel.add(lblHeader);
	    panel.add(lblLabels);
	    panel.add(lostCardButton);
		panel.add(txtUserID);
		panel.add(txtPassword);
		panel.add(loginButton);
		
		//Adjust constraints for the components
	    layout.putConstraint(SpringLayout.WEST, lblHeader, 0,  SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lblHeader, 0, SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, lblLabels, 0, SpringLayout.WEST, panel);  //right
	    layout.putConstraint(SpringLayout.NORTH, lblLabels, 110, SpringLayout.NORTH, panel);  //top
	    layout.putConstraint(SpringLayout.WEST, txtUserID, 140,  SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, txtUserID, 120,  SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, txtPassword, 140,  SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, txtPassword, 150,  SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, lostCardButton, 125,  SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, lostCardButton, 165,  SpringLayout.NORTH, panel);
	    layout.putConstraint(SpringLayout.WEST, loginButton, 95, SpringLayout.WEST, panel);
	    layout.putConstraint(SpringLayout.NORTH, loginButton, 200, SpringLayout.NORTH, panel);  
	
	    //Display the frame
		setVisible(true);
		}
}
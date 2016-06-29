package pkgCISS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Date;


import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LogInWindow extends JFrame {
	
	public static int lawyerindex = 0;
	public static int clientindex = 0;
	public static int i = 0;
	public static int j = 0;
	public boolean foundlawyer, foundclient = false;
	public int count = 1;
	
	/*Case folder;
	Lawyer counselor;
	Client customer;
	Schedule agenda;
	Billing invoice;*/
	
	JPanel panel;
	JButton loginButton;
	JLabel jlabTitle, jlblInfo, jlabLawyerID, jlabClientID, jlabPassword;
	JTextField txtUserID, txtClientID;
	JPasswordField txtPassword;
	
	public LogInWindow() throws IOException{
		
		//Create a new frame container and set the title
		setTitle("C.I.S.S. Login Form");
		setUndecorated(true);
		
		/** Add a background color and add the panel to the content page */
		panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(53, 154, 206));
		
		//Set the layout
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		
		//Give the frame an initial size and center the window
		setSize(550, 550);
		setLocationRelativeTo(null);
				
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set Icon to JFrame
		ImageIcon image = new ImageIcon("legalIcon.png");
		setIconImage(image.getImage());
		
		//Create components
		ImageIcon image1 = new ImageIcon("LoginFormTitle1.png");
		jlabTitle = new JLabel(image1);
		jlabTitle.setPreferredSize(new Dimension(360, 120));
		
		jlblInfo = new JLabel("Please log in to continue");
		jlblInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		jlblInfo.setForeground(new Color(246, 250, 252));
		
		/** Lawyer Field */
		jlabLawyerID = new JLabel("User ID");
		jlabLawyerID.setFont(new Font("Cambria", Font.PLAIN, 24));
		jlabLawyerID.setForeground(new Color(246, 250, 252));
		jlabLawyerID.setPreferredSize(new Dimension(162, 22));
		
		txtUserID = new JTextField(14);
		txtUserID.setPreferredSize(new Dimension(85, 25));
		
		/** Lawyer Password*/
		jlabPassword = new JLabel("Password");
		jlabPassword.setFont(new Font("Cambria", Font.PLAIN, 24));
		jlabPassword.setForeground(new Color(246, 250, 252));
		jlabPassword.setPreferredSize(new Dimension(162, 22));
		
		txtPassword = new JPasswordField(14);
		txtPassword.setPreferredSize(new Dimension(85, 25));
		
		txtPassword = new JPasswordField(14);
		txtPassword.setPreferredSize(new Dimension(85, 25));
		txtPassword.setEchoChar('*');
		
		//Make buttons
		
		/** Login Button*/
		loginButton = new JButton ("Login"); 
		loginButton.setFont(new Font("Cambria", Font.BOLD, 24));
		loginButton.setOpaque(false);
		loginButton.setPreferredSize(new Dimension(85, 22));
		loginButton.setForeground(new Color(251, 125, 24));
		
		//Use Image for login button
		BufferedImage loginImage = ImageIO.read(new File("LoginButton2.png"));
		loginButton = new JButton(new ImageIcon(loginImage));
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		
		//Add listener to OK button
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				//Execute when button is pressed
				txtUserID.requestFocusInWindow();
				char [] tempPass = txtPassword.getPassword();
				String userID = txtUserID.getText();
				String enteredpass = new String (tempPass);
				
				//Attorney login
				for (i = 0; i < LoadData.counselor.length; ++i) {
					if (userID.equals(LoadData.counselor[i].getlUsername()) && enteredpass.equals(LoadData.counselor[i].getlPassword())){	
						
						foundlawyer = true;
						lawyerindex = i;
						
						if(!foundlawyer && !foundclient){
							
							JOptionPane.showMessageDialog(null, "Incorrect Login! Attempts = " + count + ". Try Again!");
							++count;
							
						} if(count == 4) {
							JOptionPane.showMessageDialog(null, "This is your third attempt. Goodbye.", "KVZ Legal Services: Warning", JOptionPane.WARNING_MESSAGE);
							System.exit(99);
							}
								break;
						} 
				
					}if(foundlawyer){
							SwingUtilities.invokeLater(new Runnable() {
							public void run() {
							setVisible(false);
							new CaseDiary(lawyerindex).setVisible(true);
							}
						});
					}

			else{
			// Validate for the Client
				for (j = 0; j < LoadData.customer.length; ++j) {
			if (userID.equals(LoadData.customer[j].getClUsername()) && enteredpass.equals(LoadData.customer[j].getClPassword())){
					foundclient = true;
					clientindex = j;
					break;
				}
			}if(foundclient)
				{	
					SwingUtilities.invokeLater(new Runnable() {
					public void run() {
					setVisible(false);
					try {
						new ClientDiary(clientindex).setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}});
				}
				else if(!foundclient){
					
					JOptionPane.showMessageDialog(null, "Incorrect Login! Attempts = " + count + ". Try Again!");
					++count;
					
				} if(count == 4) {
					JOptionPane.showMessageDialog(null, "This is your third attempt. Goodbye.", "KVZ Legal Services: Warning", JOptionPane.WARNING_MESSAGE);
					System.exit(99);
			}
				}}});
		
		//Add the components to the content pane
		panel.add(jlabTitle);
		panel.add(jlblInfo);
        panel.add(jlabLawyerID);
		panel.add(txtUserID);
		panel.add(jlabPassword);
		panel.add(txtPassword);
		panel.add(loginButton);
		
		//Adjust constraints for the components
		layout.putConstraint(SpringLayout.NORTH, jlabTitle, 0, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlabTitle, 85,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblInfo, 105, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblInfo, 160,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlabLawyerID, 200, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlabLawyerID, 100,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txtUserID, 230, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txtUserID, 100,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlabPassword, 290, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlabPassword, 100,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, txtPassword, 320, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, txtPassword, 100,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, loginButton, 400, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, loginButton, 150,  SpringLayout.WEST, panel);
		
		//Display the frame
		//setVisible(true);
	}

}	
	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		LogInWindow aLoginWindow = new LogInWindow();
		//Display the frame
		aLoginWindow.setVisible(true);
	}
}*/

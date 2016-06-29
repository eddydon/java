package pkgCadre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**********************
 *  Login Method      * 
 **********************/
@SuppressWarnings("serial")
public class CADLogin extends JFrame{
	public static short log = 0, attempts=0;
	JPanel pnlLogin;
	JLabel lblfacid,lblemail,lblpwd,lblcomp,lblimage,lbllock;
	JTextField txtfacid, txtEmail;
	JPasswordField txtpwd;
	//JButton btnLogin,btnexit;
	Cadre cadre = new Cadre();
		
	CADLogin() throws IOException{	
		
	setTitle("CADRE Login Window");
	setSize(500,500);					//Remove Title bar
	setUndecorated(true); 				

	setLocationRelativeTo(null);		//Center window
	setResizable(false);  
	
	setVisible(true);
	
	// Background image
	ImageIcon image1 = new ImageIcon("images/CADLogin.png");
	JLabel lblBody = new JLabel(image1);
	lblBody.setPreferredSize(new Dimension(500, 500));
	
	//Create Label components
	lblfacid = new JLabel("Faculty Id");
	lblfacid.setFont(new Font("Arial",Font.BOLD,18));
	lblfacid.setForeground(new Color(0, 102, 240));
	
	//Create Label components
	lblemail = new JLabel("Email");
	lblemail.setFont(new Font("Arial",Font.BOLD,18));
	lblemail.setForeground(new Color(0, 102, 240));
	
	lblpwd  = new JLabel("Password");
	lblpwd.setForeground(new Color(0, 102, 240));
	lblpwd.setFont(new Font("Arial",Font.BOLD,18));
		
	lblcomp  = new JLabel("ITEK, Inc.");
	lblcomp.setForeground(new Color(0, 0, 153));
	lblcomp.setFont(new Font("Script",Font.BOLD,22));
		
	//Create text fields for Account name and password
	txtfacid = new JTextField(null,14);
	txtfacid.requestFocusInWindow();
	
	txtEmail = new JTextField(null,14);
	txtEmail.requestFocusInWindow();
  		
	txtpwd  = new JPasswordField(null,14);
	txtpwd.setEchoChar('*');
	
	//Create exit and login Buttons
	JButton btnLogin = new JButton ("Login");
	BufferedImage buttonIcon5 = ImageIO.read(new File("images/btnLogin.png"));
	btnLogin = new JButton(new ImageIcon(buttonIcon5));
	btnLogin.setPreferredSize(new Dimension(151, 42));
	btnLogin.setBorderPainted(false);
	btnLogin.setFocusPainted(false);
	btnLogin.setContentAreaFilled(false);
	btnLogin.setMnemonic(KeyEvent.VK_L);

	JButton btnExit = new JButton ("Exit");
	BufferedImage buttonIcon6 = ImageIO.read(new File("images/btnCancel.png"));
	btnExit = new JButton(new ImageIcon(buttonIcon6));
	btnExit.setPreferredSize(new Dimension(151, 43));
	btnExit.setBorderPainted(false);
	btnExit.setFocusPainted(false);
	btnExit.setContentAreaFilled(false);
	btnExit.setMnemonic(KeyEvent.VK_E);
			
	//Create panel with Spring layout
	pnlLogin = new JPanel();
	SpringLayout layLogin = new SpringLayout();
	pnlLogin.setLayout(layLogin);
	pnlLogin.setSize(350,300);
	
	ImageIcon background = new ImageIcon("OTS.png");
	lblimage = new JLabel(background);
	lblimage.setPreferredSize(new Dimension (370, 172));
	
	ImageIcon lock = new ImageIcon("lock.jpg");
	lbllock = new JLabel(lock);
	lbllock.setPreferredSize(new Dimension (48, 48));
			
	//Add Labels and text areas

	pnlLogin.add(txtfacid);
	pnlLogin.add(txtpwd);
	pnlLogin.add(btnLogin);
	pnlLogin.add(btnExit);
	pnlLogin.add(txtEmail);
	pnlLogin.add(lblBody);
						
			add(pnlLogin);
			
			// Add Login Listener
			btnLogin.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent e)
				{	char[] temppwd	 	= txtpwd.getPassword();
					String enteredpwd 	= new String(temppwd);
					String enterededuc 	= txtfacid.getText();
			  		int inteduc = Integer.parseInt(enterededuc);
			  		boolean facfound = false;
			  		
	                //Position cursor in the user account id position for data entry
			  		txtfacid.requestFocusInWindow();
			  		
			  		//Locate account and validate password
			  		for (short i = 0; i < cadre.educators.length; ++i)
		  			{	if (inteduc == cadre.educators[i].getFacID() ||
			  			    cadre.educators[i].getFacID() == 99999)
			 				{	facfound = true;
			 					log = i;
			 					break;
			 				}
		  			}
			  		
			  		if ((facfound) && enteredpwd.equals (cadre.educators[log].getPassword()))
			  		{
		  				SwingUtilities.invokeLater(new Runnable()
	  					{	public void run() 
		  						{	setVisible(false);
		  							//cadre.MainMenu();	
		  						}});
		  			}	
			  			
			  		if ((facfound) && !enteredpwd.equals (cadre.educators[log].getPassword()))
			  		{
			  			if (attempts == 3)
			  			{	JOptionPane.showMessageDialog(null,"Too many attempts...Account Disabled");
			  					txtfacid.setEnabled(false);
			  					txtpwd.setEnabled(false);
			  			}
			  			if (attempts < 3)
			  			{	JOptionPane.showMessageDialog(null,"Invalid Login..Try Again");	
			  			}
			  			++attempts;
			  		}	
		 	}});	
			
			btnExit.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e){
			SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit this application?", "Quit Cadre?", JOptionPane.YES_NO_CANCEL_OPTION);
		        // If "YES" return to Intro window
				if (reply == JOptionPane.YES_OPTION) {
					try {
						setVisible(false);
						new CADIntro().setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
				// If its cancel then
				else if (reply == JOptionPane.CANCEL_OPTION){
					return;
				}
		        else {
		           return;
		        }}});	
			}});
				
	layLogin.putConstraint(SpringLayout.WEST,lblimage,13,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,lblimage,12,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,lblcomp,90,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,lblcomp,175,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,txtfacid,230,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,txtfacid,258,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,txtEmail,230,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,txtEmail,225,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,txtpwd,230,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,txtpwd,295,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,btnLogin,59,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,btnLogin,427,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST,btnExit,294,SpringLayout.WEST,pnlLogin);
	layLogin.putConstraint(SpringLayout.NORTH,btnExit,426,SpringLayout.NORTH,pnlLogin);
	layLogin.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, pnlLogin); //right
	layLogin.putConstraint(SpringLayout.NORTH, lblBody, 0, SpringLayout.NORTH, pnlLogin);  //top
	}
}
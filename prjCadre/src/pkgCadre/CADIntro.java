package pkgCadre;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CADIntro extends JFrame {
	
	CADIntro() throws IOException{
		
	// Create a new frame container
	setTitle("Review away | Cadre");
	
	// Give the frame an initial size and center the window
	setSize(850, 567);
	setLocationRelativeTo(null);
	setUndecorated(true);
	
	// Terminate the program when the user closes the application
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// Background image
	ImageIcon image1 = new ImageIcon("images/background.png");
	JLabel lblBody = new JLabel(image1);
	lblBody.setPreferredSize(new Dimension(850, 567));
	
	// Add the panel to the content page
	JPanel panel = new JPanel();
	add(panel);
	panel.setBackground(new Color(255, 255, 255));
	
	// Display the frame
	setVisible(true);
	
	// Create Exit button
	JButton btnExit = new JButton ("Exit");
	BufferedImage buttonIcon5 = ImageIO.read(new File("images/btnExit.png"));
	btnExit = new JButton(new ImageIcon(buttonIcon5));
	btnExit.setPreferredSize(new Dimension(210, 42));
	btnExit.setBorderPainted(false);
	btnExit.setFocusPainted(false);
	btnExit.setContentAreaFilled(false);
	
	// Add Listener to Exit button
	btnExit.addActionListener (new ActionListener () {
	public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit this application?", "Quit Cadre?", JOptionPane.YES_NO_CANCEL_OPTION);
	        // If "No" return to Intro window
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
	        }
			// If its cancel then
			else if (reply == JOptionPane.CANCEL_OPTION){
				return;
			}
			// If "Yes" exit application
	        else {
	           return;
	        }}});	
		}});
	
	// Make Create Account button
	JButton btnCreateAcct = new JButton ("Create Account"); 
	BufferedImage buttonIcon0 = ImageIO.read(new File("images/btnCreateAcct.png"));
	btnCreateAcct = new JButton(new ImageIcon(buttonIcon0));
	btnCreateAcct.setPreferredSize(new Dimension(210, 42));
	btnCreateAcct.setBorderPainted(false);
	btnCreateAcct.setFocusPainted(false);
	btnCreateAcct.setContentAreaFilled(false);
			
	// Add listener for Create Account button
	btnCreateAcct.addActionListener (new ActionListener () {
	public void actionPerformed(ActionEvent e){
		setVisible(false);
		try {
			new CADSignUp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}});
	
	// Make Sign In button
	JButton lblSignIn = new JButton ("Sign In"); 
	BufferedImage buttonIcon1 = ImageIO.read(new File("images/lblSignIn.png"));
	lblSignIn = new JButton(new ImageIcon(buttonIcon1));
	lblSignIn.setPreferredSize(new Dimension(45, 16));
	lblSignIn.setBorderPainted(false);
	lblSignIn.setFocusPainted(false);
	lblSignIn.setContentAreaFilled(false);
	
	// Add listener for Sign In button
	lblSignIn.addActionListener (new ActionListener () {
	public void actionPerformed(ActionEvent e){
		// Open Login window
			setVisible(false);
			try {
				new CADLogin();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}});
			
	// Set the layout
	SpringLayout layout = new SpringLayout();
    panel.setLayout(layout);
	
	// Add the components to the content pane
    panel.add(btnExit);
    panel.add(btnCreateAcct);
    panel.add(lblSignIn);
    panel.add(lblBody);
	
	// Adjust constraints for the components
    layout.putConstraint(SpringLayout.WEST, btnExit, 438,  SpringLayout.WEST, panel); //right
    layout.putConstraint(SpringLayout.NORTH, btnExit, 423, SpringLayout.NORTH, panel);  //top
    layout.putConstraint(SpringLayout.WEST, btnCreateAcct, 199,  SpringLayout.WEST, panel); //right
    layout.putConstraint(SpringLayout.NORTH, btnCreateAcct, 423, SpringLayout.NORTH, panel);  //top
    layout.putConstraint(SpringLayout.WEST, lblSignIn, 492,  SpringLayout.WEST, panel); //right
    layout.putConstraint(SpringLayout.NORTH, lblSignIn, 487, SpringLayout.NORTH, panel);  //top
    layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, panel); //right
    layout.putConstraint(SpringLayout.NORTH, lblBody, 0, SpringLayout.NORTH, panel);  //top
	}
}
package pkgCISS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class CISSSplashscreen extends JWindow {

	private int duration;
	  public CISSSplashscreen(int d) {
	    duration = d;
	  }

	  // A simple little method to show a title screen in the center
	  // of the screen for the amount of time given in the constructor
	  public void showSplash() {
	    JPanel content = (JPanel)getContentPane();
	    content.setBackground(new Color(37, 75, 124));

	    // Set the window's bounds, centering the window
	    int width = 500;
	    int height = 360;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    setBounds(x,y,width,height);

	    // Build the splash screen
	    JLabel label = new JLabel(new ImageIcon("CISSSplash.png"));
	    JLabel copyrt = new JLabel("Copyright 2015, C.I.S.S., Edward Donkor", JLabel.CENTER);
	    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 11));
	    content.add(label, BorderLayout.CENTER);
	    content.add(copyrt, BorderLayout.SOUTH);
	    //Color oraRed = new Color(255, 255, 255);
	    copyrt.setForeground(new Color(239, 239, 239));
	    //content.setBorder(BorderFactory.createLineBorder(oraRed, 1));

	    // Display it
	    setVisible(true);

	    // Wait a little while, maybe while loading resources
	    try { Thread.sleep(duration); } catch (Exception e) {}
	    setVisible(false);
	  }

	  public void showSplashAndExit() {
	    showSplash();
	    try {
			new LogInWindow().setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// Throw a nice little title page up on the screen first
		CISSSplashscreen splash = new CISSSplashscreen(5000);
  
		// Normally, we'd call splash.showSplash() and get on with the program.
		// But, since this is only a test...
  splash.showSplashAndExit();
	}*/

}
package pkgTIMS_JS;

import java.awt.*;
import java.io.*;
import java.sql.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
	  private int duration;
	  public SplashScreen(int d) {
	    duration = d;
	  }

	  public void showSplash() throws IOException {
	    JPanel content = (JPanel)getContentPane();
	    
	    //Set project icon
	    ImageIcon image = new ImageIcon("images/TIMSIcon.png");
		setIconImage(image.getImage());

	    // Set the window's bounds, centering the window
	    int width = 500;
	    int height = 739;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    setBounds(x,y,width,height);

	    // Build the splash screen
	    JLabel label = new JLabel(new ImageIcon("images/TIMSss.png"));
	    content.add(label, BorderLayout.CENTER);

	    // Display it
	    setVisible(true);

	    // Wait a little while, maybe while loading resources
	    try { Thread.sleep(duration); } catch (Exception e) {}
	    setVisible(false);
	  }

	  // Call the LoadData and Login Window after SplashScreen window shows
	  public void showSplashAndExit() throws SQLException, IOException {
	    showSplash();
	  }
	}
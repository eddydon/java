package pkgCISS;

/** Name:		Edward Donkor - Programmer, Sydel Alleyne - Documentaion/Powerpoint, Victoria Amoo
 * 	Date:		March 2, 1015 - April 19, 2015
 * 	Program:	Comprehensive Interactive Scheduling System (C.I.S.S.) 	
 * 	Purpose:	
 */

import java.io.IOException;
import java.text.ParseException;
import javax.swing.UIManager;

public class CISS {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		CISSSplashscreen splash = new CISSSplashscreen(5000);
		splash.showSplashAndExit();
		new LoadData();
		new LogInWindow();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

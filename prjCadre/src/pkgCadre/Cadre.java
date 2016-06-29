package pkgCadre;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Cadre {
	
	Faculty educators[] = new Faculty[2];
	Outcomes result[] = new Outcomes[2];
	Technologies software[] = new Technologies[2];

	public static void main(String[] args) throws IOException, ParseException, SQLException {
	// Load SplashScreen
	//SplashScreen splash = new SplashScreen(5000);
	//splash.showSplashAndExit();
	
	// Load database
	//new LoadData(); 
	
	// Open Login Window after SplashScreen has timed out
	//new CADIntro();
	try {
		UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		try {
			new CADIntro();//.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}});
	}
}
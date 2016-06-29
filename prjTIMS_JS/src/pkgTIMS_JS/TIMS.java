package pkgTIMS_JS;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.UIManager;

public class TIMS {

	public static void main(String[] args) throws IOException, ParseException, SQLException {
		SplashScreen splash = new SplashScreen(5000);
		splash.showSplashAndExit();
		new LoadData(); 
		new LoginWindow();
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				//UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
}


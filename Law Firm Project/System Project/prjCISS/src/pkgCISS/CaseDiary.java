package pkgCISS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

@SuppressWarnings("serial")
public class CaseDiary extends JFrame {
	
	public static int lawyerindex = 0;
	static Case folder;
	static Lawyer counselor;
	static Client customer;
	static Schedule agenda;
	static Billing invoice;
	
	JButton logoutButton;
	JLabel jlblTitle, jlblCaseInfo, jlblCaseName, jlblCaseNumber, jlblPartyName, jlblPracticeArea, jlblCaseDetails, jlblImportantDate, jlblStaffLawyer, jlblCaseID, jlblCaseName2,
	jlblCourt, jlblCaseDescription, jlblDateOpened, jlblDateClosed;
	JTabbedPane tabbedPane;
	JTextField jtxtCaseName, jtxtPartyName, jtxtPracticeArea, jtxtStaffLawyer, jtxtCaseID, jtxtCaseName2, jtxtCourt, jtxtDateOpened, jtxtDateClosed;
	JTextArea jtxtAreaCaseDescription;

	public CaseDiary(final int lawyerindex){
		
		//Create a new frame container and set the title
		setTitle("C.I.S.S. - KVZ Legal Services: Case Diary");
		
		//Give the frame an initial size and center the window
		setSize(950, 550);
		getContentPane().setBackground(new Color(172, 181, 188));
		setLocationRelativeTo(null);
		
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("legalIcon.png");
		setIconImage(image.getImage());
		
		//JLabel label = new JLabel(new ImageIcon("KVZTitle.png"));
		jlblTitle = new JLabel("Welcome, " + " " +  LoadData.counselor[lawyerindex].getlFName() + " " + LoadData.counselor[lawyerindex].getlLName());
		jlblTitle.setFont(new Font("Cambria", Font.PLAIN, 18));
		jlblTitle.setForeground(new Color(30, 35, 39));
		
		/** Tabbed Pane*/
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Cambria", Font.PLAIN, 20));
		tabbedPane.setForeground(new Color(245, 254, 251));
		//tabbedPane.setForeground(new Color(79, 90, 96));
		//tabbedPane.setBackground(new Color(79, 90, 96));
		tabbedPane.setBackground(new Color(53, 154, 206));
		tabbedPane.setUI(new BasicTabbedPaneUI() {
	        @Override
	        protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
	            return 100; // the width of the tab
	        }
	        
	        protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight){
				return 25; // the height of the tab
	        }
	    });
				
		//Create the "cards"
		tabbedPane.addTab("Clients", new ClientsPanel(lawyerindex));
		tabbedPane.addTab("Cases", new CasesPanel(lawyerindex));
		tabbedPane.addTab("Billing", new BillingPanel(lawyerindex));
		tabbedPane.addTab("Calendar", new CalendarPanel(lawyerindex));
		//tabbedPane.addTab("Logout", new LogoutPanel());
		
		/** Log Out Button*/
		logoutButton = new JButton("LOGOUT"); 
		logoutButton.setFont(new Font("Cambria", Font.BOLD, 11));
		logoutButton.setOpaque(false);
		logoutButton.setPreferredSize(new Dimension(85, 22));
		logoutButton.setForeground(new Color(251, 125, 24));
		
		logoutButton.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e){
				//Execute when button is selected
				JOptionPane.showMessageDialog(null, "Goodbye!", "KVZ Legal Services: Message", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		getContentPane().add(jlblTitle, SpringLayout.NORTH);
		//getContentPane().add(logoutButton,);
		
	}
	
	/** Case Pane */
	class ClientsPanel extends JPanel{
		
		public ClientsPanel(int lawyerindex){
			setBackground(new Color(172, 181, 188));
			
			/** Create labels*/
			JLabel jlblClient = new JLabel("CLIENT ");
			jlblClient.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
			jlblClient.setForeground(new Color(246, 250, 252));
			
			JLabel jlblClientID = new JLabel("Client ID: ");
			jlblClientID.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblClientID.setForeground(new Color(0, 0, 0));
			
			JLabel jlblFirstN = new JLabel("First Name: ");
			jlblFirstN.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblFirstN.setForeground(new Color(0, 0, 0));
			
			JLabel jlblLastN = new JLabel("Last Name: ");
			jlblLastN.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblLastN.setForeground(new Color(0, 0, 0));
			
			JLabel jlblStreet = new JLabel("Street: ");
			jlblStreet.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblStreet.setForeground(new Color(0, 0, 0));
			
			JLabel jlblCity = new JLabel("City: ");
			jlblCity.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCity.setForeground(new Color(0, 0, 0));
			
			JLabel jlblState = new JLabel("State: ");
			jlblState.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblState.setForeground(new Color(0, 0, 0));
			
			JLabel jlblPostal = new JLabel("Postal Code: ");
			jlblPostal.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblPostal.setForeground(new Color(0, 0, 0));
			
			JLabel jlblPhone = new JLabel("Telephone: ");
			jlblPhone.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblPhone.setForeground(new Color(0, 0, 0));
			
			JLabel jlblEmail = new JLabel("Email: ");
			jlblEmail.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblEmail.setForeground(new Color(0, 0, 0));
			
			/** JTextField */
			JTextField jtxtClientID = new JTextField(15);
			jtxtClientID.setEnabled(false);
			
			JTextField jtxtFirstN = new JTextField(15);
			jtxtFirstN.setEnabled(false);
			
			JTextField jtxtLastN = new JTextField(15);
			jtxtLastN.setEnabled(false);
			
			JTextField jtxtStreet = new JTextField(15);
			jtxtStreet.setEnabled(false);
			
			JTextField jtxtCity = new JTextField(15);
			jtxtCity.setEnabled(false);
			
			JTextField jtxtState = new JTextField(15);
			jtxtState.setEnabled(false);
			
			JTextField jtxtPostal = new JTextField(15);
			jtxtPostal.setEnabled(false);
			
			JTextField jtxtPhone = new JTextField(15);
			jtxtPhone.setEnabled(false);
			
			JTextField jtxtEmail = new JTextField(15);
			jtxtEmail.setEnabled(false);
			
			/** Create Buttons */
			
			//JButtons
			JButton addButton = new JButton("Add");
			addButton.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 16));
			addButton.setOpaque(false);
			addButton.setPreferredSize(new Dimension(85, 22));
			addButton.setForeground(new Color(53, 154, 206));
			
			JButton editButton = new JButton("Edit");
			editButton.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 16));
			editButton.setOpaque(false);
			editButton.setPreferredSize(new Dimension(85, 22));
			editButton.setForeground(new Color(53, 154, 206));
			
			JButton deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 16));
			deleteButton.setOpaque(false);
			deleteButton.setPreferredSize(new Dimension(85, 22));
			deleteButton.setForeground(new Color(53, 154, 206));
			
			/** Combo Box */
			// create a combo box with items specified in the String array:
			String[] transferFrom = new String[] {"Select Client", "Jackson, Michael"};
			JComboBox<String> fromList = new JComboBox<String>(transferFrom);
			
			// Appearance
			fromList.setFont(new Font("Helvetica", Font.PLAIN, 12));
			fromList.setMaximumRowCount(3);
			fromList.setBackground(new Color(255, 255, 255));
			fromList.setPreferredSize(new Dimension(300, 20));
					
			//Make the combo box editable so we can add new item when needed
			fromList.setEditable(false);
			
			add(jlblClient);
			add(fromList);
			add(jlblClientID);
			add(jtxtClientID);
			add(jlblFirstN);
			add(jtxtFirstN);
			add(jlblLastN);
			add(jtxtLastN);
			add(jlblStreet);
			add(jtxtStreet);
			add(jlblCity);
			add(jtxtCity);
			add(jlblState);
			add(jtxtState);
			add(jlblPostal);
			add(jtxtPostal);
			add(jlblPhone);
			add(jtxtPhone);
			add(jlblEmail);
			add(jtxtEmail);
			add(addButton);
			add(editButton);
			add(deleteButton);
			
			/** Using the SpringLayout */
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			
			layout.putConstraint(SpringLayout.NORTH, jlblClient, 25, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblClient, 305,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, fromList, 28, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, fromList, 375,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblClientID, 80, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblClientID, 100,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtClientID, 80, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtClientID, 190,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblFirstN, 110, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblFirstN, 100,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtFirstN, 110, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtFirstN, 190,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblLastN, 140, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblLastN, 100,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtLastN, 140, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtLastN, 190,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblStreet, 170, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblStreet, 100,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtStreet, 170, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtStreet, 190,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCity, 75, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCity, 440,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtCity, 75, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtCity, 550,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblState, 105, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblState, 440,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtState, 105, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtState, 550,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblPostal, 135, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblPostal, 440,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtPostal, 135, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtPostal, 550,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblPhone, 165, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblPhone, 440,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtPhone, 165, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtPhone, 550,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblEmail, 195, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblEmail, 440,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtEmail, 195, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtEmail, 550,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, addButton, 330, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, addButton, 195,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, editButton, 330, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, editButton, 405,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, deleteButton, 330, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, deleteButton, 615,  SpringLayout.WEST, /*new JPanel()*/this);
			
			
		}
	}

	/** Address Pane */
	class CasesPanel extends JPanel{
		
		public CasesPanel(int lawyerindex){
			
			//setBackground(new Color(245, 254, 251));
			setBackground(new Color(172, 181, 188));
			
			/** Array of information */
			/*String[] columns = {"CASE INFORMATION", "ACTIONS", "RESULTS"};
			Object[][] data    = {
					{"Jackson vs State of NY", "State Taxation", "Pending"}
				};*/
			
			/** Create labels*/
			jlblCaseInfo = new JLabel("CASE INFORMATION");
			jlblCaseInfo.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
			jlblCaseInfo.setForeground(new Color(246, 250, 252));
			
			jlblCaseName = new JLabel("CASE NAME");
			jlblCaseName.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCaseName.setForeground(new Color(30, 35, 39));
			
			jlblCaseNumber = new JLabel("CASE NUMBER");
			jlblCaseNumber.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCaseNumber.setForeground(new Color(30, 35, 39));
			
			jlblPartyName = new JLabel("PARTY NAME");
			jlblPartyName.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblPartyName.setForeground(new Color(30, 35, 39));
			
			jlblPracticeArea = new JLabel("PRACTICE AREA");
			jlblPracticeArea.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblPracticeArea.setForeground(new Color(30, 35, 39));
			
			jlblCaseDetails = new JLabel("CASE DETAILS");
			jlblCaseDetails.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
			jlblCaseDetails.setForeground(new Color(246, 250, 252));
			
			jlblImportantDate = new JLabel("IMPORTANT DATES");
			jlblImportantDate.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
			jlblImportantDate.setForeground(new Color(246, 250, 252));
			
			jlblStaffLawyer = new JLabel("Assigned Staff Lawyer: ");
			jlblStaffLawyer.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblStaffLawyer.setForeground(new Color(0, 0, 0));
			
			jlblCaseID = new JLabel("Case #: ");
			jlblCaseID.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCaseID.setForeground(new Color(0, 0, 0));
			
			jlblCaseName2 = new JLabel("Case Name: ");
			jlblCaseName2.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCaseName2.setForeground(new Color(0, 0, 0));
			
			jlblCourt = new JLabel("Court: ");
			jlblCourt.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCourt.setForeground(new Color(0, 0, 0));
			
			jlblCaseDescription = new JLabel("Case Description: ");
			jlblCaseDescription.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblCaseDescription.setForeground(new Color(0, 0, 0));
			
			jlblDateOpened = new JLabel("Date Opened: ");
			jlblDateOpened.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblDateOpened.setForeground(new Color(0, 0, 0));
			
			jlblDateClosed = new JLabel("Date Closed: ");
			jlblDateClosed.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
			jlblDateClosed.setForeground(new Color(0, 0, 0));
			
			
			/** Textfields */
			jtxtCaseName = new JTextField(15);
			jtxtCaseName.setEnabled(false);
			
			jtxtPartyName = new JTextField(15);
			jtxtPartyName.setEnabled(false);
			
			jtxtPracticeArea = new JTextField(15);
			jtxtPracticeArea.setEnabled(false);
			
			jtxtStaffLawyer = new JTextField(15);
			jtxtStaffLawyer.setEnabled(false);
			
			jtxtCaseID = new JTextField(15);
			jtxtCaseID.setEnabled(false);
			
			jtxtCaseName2 = new JTextField(15);
			jtxtCaseName2.setEnabled(false);
			
			jtxtCourt = new JTextField(15);
			jtxtCourt.setEnabled(false);
			
			jtxtDateOpened = new JTextField(15);
			jtxtDateOpened.setEnabled(false);
			
			jtxtDateClosed = new JTextField(15);
			jtxtDateClosed.setEnabled(false);
			
			/** TextArea */
			jtxtAreaCaseDescription = new JTextArea(2, 20);
			jtxtAreaCaseDescription.setFont(new Font("Serif", Font.ITALIC, 16));
			jtxtAreaCaseDescription.setLineWrap(true);
			jtxtAreaCaseDescription.setWrapStyleWord(true);
			/*JScrollPane scrollPane = new JScrollPane(jtxtAreaCaseDescription);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(new Dimension(250, 250));*/
			jtxtAreaCaseDescription.setEditable(false);
			
			/** Combo Box */
			// create a combo box with items specified in the String array:
			String[] transferFrom = new String[] {"Select Case", "Jackson vs State of NY"};
			JComboBox<String> fromList = new JComboBox<String>(transferFrom);
			
			// Appearance
			fromList.setFont(new Font("Helvetica", Font.PLAIN, 12));
			fromList.setMaximumRowCount(3);
			fromList.setBackground(new Color(255, 255, 255));
			fromList.setPreferredSize(new Dimension(170, 20));
					
			//Make the combo box editable so we can add new item when needed
			fromList.setEditable(false);
			
			/** JTable */
			/*JTable table = new JTable(data, columns);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);*/
			
			/** Using the BorderLayout */
			/*setLayout(new BorderLayout());
			add(jlblHeading, BorderLayout.PAGE_START);
			add(scrollPane, BorderLayout.CENTER);*/
			//setLayout(new SpringLayout());
			
			/** Using the SpringLayout */
			SpringLayout layout = new SpringLayout();
			setLayout(layout);
			
			add(jlblCaseInfo);
			add(jlblCaseName);
			add(jtxtCaseName);
			add(jlblCaseNumber);
			add(fromList);
			add(jlblPartyName);
			add(jtxtPartyName);
			add(jlblPracticeArea);
			add(jtxtPracticeArea);
			add(jlblCaseDetails);
			add(jlblStaffLawyer);
			add(jtxtStaffLawyer);
			add(jlblCaseID);
			add(jtxtCaseID);
			add(jlblCaseName2);
			add(jtxtCaseName2);
			add(jlblCourt);
			add(jtxtCourt);
			add(jlblCaseDescription);
			add(jtxtAreaCaseDescription);
			add(jlblImportantDate);
			add(jlblDateOpened);
			add(jtxtDateOpened);
			add(jlblDateClosed);
			add(jtxtDateClosed); 
			
			layout.putConstraint(SpringLayout.NORTH, jlblCaseInfo, 5, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseInfo, 25,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseName, 35, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseName, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtCaseName, 55, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtCaseName, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseNumber, 85, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseNumber, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, fromList, 105, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, fromList, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblPartyName, 135, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblPartyName, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtPartyName, 160, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtPartyName, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblPracticeArea, 190, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblPracticeArea, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtPracticeArea, 210, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtPracticeArea, 50,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseDetails, 35, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseDetails, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblStaffLawyer, 60, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblStaffLawyer, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtStaffLawyer, 80, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtStaffLawyer, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseID, 110, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseID, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtCaseID, 130, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtCaseID, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseName2, 160, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseName2, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtCaseName2, 180, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtCaseName2, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCourt, 210, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCourt, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtCourt, 230, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtCourt, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblCaseDescription, 260, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblCaseDescription, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtAreaCaseDescription, 280, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtAreaCaseDescription, 300,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblImportantDate, 35, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblImportantDate, 555,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblDateOpened, 60, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblDateOpened, 555,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtDateOpened, 80, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtDateOpened, 555,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jlblDateClosed, 110, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jlblDateClosed, 555,  SpringLayout.WEST, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.NORTH, jtxtDateClosed, 130, SpringLayout.NORTH, /*new JPanel()*/this);
			layout.putConstraint(SpringLayout.WEST, jtxtDateClosed, 555,  SpringLayout.WEST, /*new JPanel()*/this);


		}
	}
	

	/** Billing Pane */
	class BillingPanel extends JPanel{
		
		public BillingPanel(int lawyerindex){
			setBackground(new Color(172, 181, 188));
		}
	}

	/** Calendar Pane */
	class CalendarPanel extends JPanel{
		
		public CalendarPanel(int lawyerindex){
			//setBackground(new Color(53, 154, 206));
			setBackground(new Color(172, 181, 188));
		}
	}

	/** Logout Pane */
	/*class LogoutPanel extends JPanel{
		
		public LogoutPanel(){
			setBackground(new Color(53, 154, 206));
		}
	}*/

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CaseDiary diary = new CaseDiary(lawyerindex);
		//Display the frame
		diary.setVisible(true);
	}*/
}

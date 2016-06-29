package pkgCISS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ClientDiary extends JFrame {
	
	public static int clientindex = 0;
	static Case folder;
	static Lawyer counselor;
	static Client customer;
	static Schedule agenda;
	static Billing invoice;
	
	JPanel panel;
	JLabel jlblImageIcon, jlblTitle, jlblCaseInfo, jlblCaseName, jlblCaseNumber, jlblStaffLawyer, jlblCourt, jlblCaseID, jlblCaseDescription, jlblImportantDate,jlblDateOpened, jlblDateClosed;
	JButton logoutButton;
	JTextField jtxtCaseName, jtxtCaseNumber, jtxtStaffLawyer, jtxtCourt, jtxtDateOpened, jtxtDateClosed;
	JTextArea jtxtAreaCaseDescription;
	
	ClientDiary(int clientindex) throws IOException{
		
		//Create a new frame container and set the title
		setTitle("KVZ Legal Services - Client Diary");
				
		/** Add a background color and add the panel to the content page */
		panel = new JPanel();
		add(panel);
		panel.setBackground(new Color(172, 181, 188));
		//panel.setBackground(new Color(53, 154, 206));		
				
		//Set the layout
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
				
		//Give the frame an initial size and center the window
		setSize(950, 550);
		setLocationRelativeTo(null);
						
		//Terminate the program when the user closes the application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("legalIcon.png");
		setIconImage(image.getImage());
		
		/** Create components */
		ImageIcon image1 = new ImageIcon("LogoPt6.png");
		jlblImageIcon = new JLabel(image1);
		jlblImageIcon.setPreferredSize(new Dimension(360, 120));
		
		jlblTitle = new JLabel("Welcome, " + " " +  LoadData.customer[clientindex].getClFName() + " " + LoadData.customer[clientindex].getClLName());
		jlblTitle.setFont(new Font("Cambria", Font.PLAIN, 18));
		jlblTitle.setForeground(new Color(0, 0, 0));
		
		//Make buttons
		
		/** Log Out Button*/
		logoutButton = new JButton("Logout"); 
		logoutButton.setFont(new Font("Cambria", Font.BOLD, 11));
		logoutButton.setOpaque(false);
		logoutButton.setPreferredSize(new Dimension(85, 22));
		logoutButton.setForeground(new Color(251, 125, 24));
		
		//Use Image
		BufferedImage logoutIcon = ImageIO.read(new File("LogoutButton.png"));
		logoutButton = new JButton(new ImageIcon(logoutIcon));
		logoutButton.setBorderPainted(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setContentAreaFilled(false);
		
		logoutButton.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e){
				//Execute when button is selected
				JOptionPane.showMessageDialog(null, "Goodbye!", "KVZ Legal Services: Message", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		
		
		/** Create labels*/
		jlblCaseInfo = new JLabel("CASE INFORMATION");
		jlblCaseInfo.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
		jlblCaseInfo.setForeground(new Color(246, 250, 252));
		
		jlblCaseName = new JLabel("Case Name");
		jlblCaseName.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblCaseName.setForeground(new Color(0, 0, 0));
			
		jlblCaseNumber = new JLabel("Case Number");
		jlblCaseNumber.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblCaseNumber.setForeground(new Color(0, 0, 0));
		
		jlblImportantDate = new JLabel("IMPORTANT DATES");
		jlblImportantDate.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 18));
		jlblImportantDate.setForeground(new Color(246, 250, 252));
		
		jlblStaffLawyer = new JLabel("Assigned Staff Lawyer: ");
		jlblStaffLawyer.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblStaffLawyer.setForeground(new Color(0, 0, 0));
		
		jlblCourt = new JLabel("Court ");
		jlblCourt.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblCourt.setForeground(new Color(0, 0, 0));
		
		jlblCaseDescription = new JLabel("Case Description ");
		jlblCaseDescription.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblCaseDescription.setForeground(new Color(0, 0, 0));
		
		jlblDateOpened = new JLabel("Date Opened ");
		jlblDateOpened.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblDateOpened.setForeground(new Color(0, 0, 0));
		
		jlblDateClosed = new JLabel("Date Closed ");
		jlblDateClosed.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 15));
		jlblDateClosed.setForeground(new Color(0, 0, 0));
		
		/** Textfields */
		jtxtStaffLawyer = new JTextField(" " + LoadData.counselor[clientindex].getlFName() + " " + LoadData.counselor[clientindex].getlLName(), 15);
		jtxtStaffLawyer.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtStaffLawyer.setEnabled(false);
		
		jtxtCaseName = new JTextField(" " + LoadData.folder[clientindex].getCaseName(), 15);
		jtxtCaseName.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtCaseName.setEnabled(false);
		
		jtxtCaseNumber = new JTextField(" " + LoadData.folder[clientindex].getcID(), 15);
		jtxtCaseNumber.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtCaseNumber.setEnabled(false);
		
		jtxtCourt = new JTextField(" " + LoadData.folder[clientindex].getCourt(), 15);
		jtxtCourt.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtCourt.setEnabled(false);
		
		jtxtDateOpened = new JTextField(" " + LoadData.folder[clientindex].getDateopen(), 15);
		jtxtDateOpened.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtDateOpened.setEnabled(false);
		
		jtxtDateClosed = new JTextField(" " + LoadData.folder[clientindex].getDateclosed(), 15);
		jtxtDateClosed.setFont(new Font("Cambria", Font.TRUETYPE_FONT, 13));
		jtxtDateClosed.setEnabled(false);
		
		/** TextArea */
		jtxtAreaCaseDescription = new JTextArea(" " + LoadData.folder[clientindex].getDescription(), 2, 20);
		jtxtAreaCaseDescription.setFont(new Font("Serif", Font.ITALIC, 16));
		jtxtAreaCaseDescription.setLineWrap(true);
		jtxtAreaCaseDescription.setWrapStyleWord(true);
		jtxtAreaCaseDescription.setEditable(false);
		
		//Add the components to the content pane
		panel.add(jlblImageIcon);
		panel.add(jlblTitle);
		panel.add(logoutButton);
		panel.add(jlblCaseInfo);
		panel.add(jlblStaffLawyer);
		panel.add(jtxtStaffLawyer);
		panel.add(jlblCaseName);
		panel.add(jtxtCaseName);
		panel.add(jlblCaseNumber);
		panel.add(jtxtCaseNumber);
		panel.add(jlblStaffLawyer);
		panel.add(jtxtStaffLawyer);
		panel.add(jlblCourt);
		panel.add(jtxtCourt);
		panel.add(jlblCaseDescription);
		panel.add(jtxtAreaCaseDescription);
		panel.add(jlblImportantDate);
		panel.add(jlblDateOpened);
		panel.add(jtxtDateOpened);
		panel.add(jlblDateClosed);
		panel.add(jtxtDateClosed);
		
		//Adjust constraints for the components
		layout.putConstraint(SpringLayout.NORTH, jlblImageIcon, 0, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblImageIcon, -25,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblTitle, 30, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblTitle, 450,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, logoutButton, 15, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, logoutButton, 740,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblCaseInfo, 110, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblCaseInfo, 30,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblStaffLawyer, 150, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblStaffLawyer, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtStaffLawyer, 170, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtStaffLawyer, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblCaseName, 200, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblCaseName, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtCaseName, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtCaseName, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblCaseNumber, 250, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblCaseNumber, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtCaseNumber, 270, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtCaseNumber, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblCourt, 300, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblCourt, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtCourt, 320, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtCourt, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblCaseDescription, 350, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblCaseDescription, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtAreaCaseDescription, 375, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtAreaCaseDescription, 35,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblImportantDate, 110, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblImportantDate, 390,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblDateOpened, 150, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblDateOpened, 400,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtDateOpened, 170, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtDateOpened, 400,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jlblDateClosed, 200, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jlblDateClosed, 400,  SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jtxtDateClosed, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, jtxtDateClosed, 400,  SpringLayout.WEST, panel);
		
	}

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ClientDiary diary = new ClientDiary(clientindex);
		//Display the frame
		diary.setVisible(true);
	}*/

}

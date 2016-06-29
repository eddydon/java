package pkgCadre;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class CADSignUp extends JFrame {
	
    CADSignUp() throws IOException{
        
    //Frame and Panel
    //JFrame Sign = new JFrame();
    JPanel Pane = new JPanel();
    setTitle("Sign up");
    setUndecorated(true);
    
    setSize(720,700);
    SpringLayout layout = new SpringLayout();
    Pane.setLayout(layout);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
    
    // Background image
 	ImageIcon image1 = new ImageIcon("images/CADSignUp.png");
 	JLabel lblBody = new JLabel(image1);
 	lblBody.setPreferredSize(new Dimension(720, 700));

    //Buttons
    JButton btnSignUp = new JButton("Sign Up");
    BufferedImage buttonIcon5 = ImageIO.read(new File("images/btnSignUp.png"));
    btnSignUp = new JButton(new ImageIcon(buttonIcon5));
    btnSignUp.setPreferredSize(new Dimension(151, 43));
    btnSignUp.setBorderPainted(false);
    btnSignUp.setFocusPainted(false);
    btnSignUp.setContentAreaFilled(false);
    btnSignUp.setMnemonic(KeyEvent.VK_E);
    
    JButton btnExit = new JButton ("Exit");
	BufferedImage buttonIcon6 = ImageIO.read(new File("images/btnCancel.png"));
	btnExit = new JButton(new ImageIcon(buttonIcon6));
	btnExit.setPreferredSize(new Dimension(151, 43));
	btnExit.setBorderPainted(false);
	btnExit.setFocusPainted(false);
	btnExit.setContentAreaFilled(false);
	btnExit.setMnemonic(KeyEvent.VK_E);
    
    //Text fields
    JTextField txtfn = new JTextField();
    txtfn.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txtln = new JTextField();
    txtln.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txtad = new JTextField();
    txtad.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txttele = new JTextField();
    txttele.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txtuser = new JTextField();
    txtuser.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txtcn = new JTextField();
    txtcn.setPreferredSize( new Dimension( 150, 24 ) );
    JTextField txtce = new JTextField();
    txtce.setPreferredSize( new Dimension( 150, 24 ) );
    
    //password fields
    JPasswordField txtpassword = new JPasswordField();
    txtpassword.setEchoChar('*');
    txtpassword.setPreferredSize( new Dimension( 150, 24 ) );
    
    JPasswordField txtretype = new JPasswordField();
    txtretype.setEchoChar('*');
    txtretype.setPreferredSize( new Dimension( 150, 24 ) );
    
    //Combo box(Title)
    String[] title = new String[]{"Mr.", "Ms.", "Mrs."};
    JComboBox<String> titlelist = new JComboBox<String>(title);
    titlelist.setMaximumRowCount(3);
    titlelist.setEditable(false);
    
    //Combo box(Years Active)
	String[] years = new String[]{"0 - 3", "4 - 6", "7+"};
	JComboBox<String> yearslist = new JComboBox<String>(years);
	titlelist.setMaximumRowCount(3);
	titlelist.setEditable(false);
        
    //Combo box(Department)
    String[] dept = new String[]{"Technology", "Business", "Science"};
    JComboBox<String> deptlist = new JComboBox<String>(dept);
    titlelist.setMaximumRowCount(10);
    titlelist.setEditable(false);
    titlelist.setPreferredSize( new Dimension( 150, 24 ) );
    
    //Combo box(Highest Degree)
    String[] degree = new String[]{"Associate", "Bachelor", "Master", "Ph.D"};
    JComboBox<String> degreelist = new JComboBox<String>(degree);
    titlelist.setMaximumRowCount(4);
    titlelist.setEditable(false);

    //ButtonGroup aGroup= new ButtonGroup();
    JCheckBox english = new JCheckBox("English");
    JCheckBox math = new JCheckBox("Math");
    JCheckBox tech = new JCheckBox("Technology");
    JCheckBox heal = new JCheckBox("Health");
    JCheckBox sci = new JCheckBox("Science");
    JCheckBox bus = new JCheckBox("Business");
    JCheckBox pys = new JCheckBox("Education");
    JCheckBox lib = new JCheckBox("Liberal Arts");
    JCheckBox mus = new JCheckBox("Music");
    JCheckBox law = new JCheckBox("Law");
    
    //Add-ons(Labels)
    add(Pane);
    Pane.add(titlelist);
    Pane.add(yearslist);
    Pane.add(deptlist);
    Pane.add(degreelist);
    Pane.add(txtfn);
    Pane.add(txtln);
    Pane.add(txtad);
    Pane.add(txttele);
    Pane.add(txtuser);
    Pane.add(txtcn);
    Pane.add(txtce);
    Pane.add(txtpassword);
    Pane.add(txtretype);
    Pane.add(english);
    Pane.add(math);
    Pane.add(tech);
    Pane.add(heal);
    Pane.add(sci);
    Pane.add(bus);
    Pane.add(pys);
    Pane.add(mus);
    Pane.add(lib);
    Pane.add(law);
    Pane.add(btnSignUp);
    //Pane.add(gbButton);
    Pane.add(btnExit);
    Pane.add(lblBody);
    
    //Sign up action
    btnSignUp.addActionListener(new ActionListener()
    {
    public void    actionPerformed(ActionEvent e)
    {

          char[] enterpass = txtpassword.getPassword();
            String enteruser = txtuser.getText();
            String enteredpass = new String(enterpass);
            
            
           // if (enteruser == m[0].getFname() && enteredpass == m[0].getPassword())
            {
            	setVisible(false);
            }
            
             if (enteruser.length()==0 || enterpass.length == 0)
            {JOptionPane.showMessageDialog(null,"Try Again.");}
           
                    
             if(enterpass.length > 8)
            {
                JOptionPane.showMessageDialog(null,"Wrong.");
            }        
    }}); 
    
    btnExit.addActionListener (new ActionListener () {
		public void actionPerformed(ActionEvent e){
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit this application?", "Quit Cadre?", JOptionPane.YES_NO_CANCEL_OPTION);
	        // If "No" return to Intro window
			if (reply == JOptionPane.YES_OPTION) {
				try {
					new CADSignUp().setVisible(false);
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
    	
    //Placement(Labels)
    layout.putConstraint(SpringLayout.WEST, titlelist, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, titlelist, 157, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, yearslist, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, yearslist, 379, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, deptlist, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, deptlist, 342, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, degreelist, 530,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, degreelist, 379, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtfn, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtfn, 194,  SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtln, 530, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtln, 194, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtuser, 175, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtuser, 231, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtpassword, 175, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtpassword, 268, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtretype, 530, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtretype, 268, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtcn, 175, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtcn, 305, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtad, 530, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtad, 305, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txttele, 530, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txttele, 342, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, txtce, 530, SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, txtce, 231, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, btnExit, 401,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, btnExit, 623, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, btnSignUp, 166,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, btnSignUp, 623, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, english, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, english,455 , SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, math, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, math, 485, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, tech, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, tech, 515, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, heal, 175,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, heal, 545, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, sci, 355,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, sci, 455, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, bus, 355,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, bus, 485, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, pys, 355,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, pys, 515, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, lib, 530,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, lib, 455, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, mus, 530,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, mus, 485, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, law, 530,  SpringLayout.WEST, Pane);
    layout.putConstraint(SpringLayout.NORTH, law, 515, SpringLayout.NORTH, Pane);
    layout.putConstraint(SpringLayout.WEST, lblBody, 0,  SpringLayout.WEST, Pane); //right
    layout.putConstraint(SpringLayout.NORTH, lblBody, 0, SpringLayout.NORTH, Pane);  //top
	}
}
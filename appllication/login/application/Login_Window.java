package login.application;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.SwingUtilities;

import app_Content.Application_Content;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Login_Window extends JFrame{
	
	private JPanel main_Panel;
	
	private final int X = 700, Y = 500;
	
	public Login_Window() {
		
		//title of the JFrame
		this.setTitle("Login Window");
		
		//insert the image location
		ImageIcon titleImage = new ImageIcon("image/bank.png");
		
		//get the image
		Image titleIcon = titleImage.getImage();
		
		//set the title image
		this.setIconImage(titleIcon);
		
		//make the application able to close manually 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//make the application visible 
		this.setVisible(true);
		
		//defining the main panel
		main_Panel = new JPanel(new BorderLayout());
		
		//set main panel background color to blue
		main_Panel.setBackground(Application_Content.BLUE_30);
		
		//add the calling method to the panel
		main_Panel.add(panel_West(), BorderLayout.WEST);
		main_Panel.add(east_Panel(), BorderLayout.EAST);
		
		//adding to the main panel
		this.add(main_Panel);
		
		//set the size of the windows
		this.setSize(new Dimension(X,Y));
		
		this.getContentPane().setBackground(Color.BLACK);
		
		//when the program start locate the application center
		this.setLocationRelativeTo(null);
		
		//set the window unable to expand or resize 
		this.setResizable(false);
	}
	
	public JPanel panel_West() {
		JPanel panel_West = new JPanel(new BorderLayout());
		panel_West.setBackground(Application_Content.BLUE_30);
		panel_West.setBorder(BorderFactory.createEmptyBorder(35,25,35,25));
		
		//west panel
		JPanel panel_West_Layout = new JPanel(new BorderLayout());
		panel_West_Layout.setPreferredSize(new Dimension(300,0));
		panel_West_Layout.setBackground(Application_Content.DEEP_BLUE);
		
		//image label
		JLabel iconImage = iconImage("image/bank.png");
		iconImage.setBorder(BorderFactory.createEmptyBorder(70,0,0,0)); //adding empty space
		
		JLabel lblText = new JLabel("Welcome To The Sky Bank");
		lblText.setBorder(BorderFactory.createEmptyBorder(0,0,70,0)); //adding empty space
		lblText.setHorizontalAlignment(SwingConstants.CENTER); // center the label
		lblText.setFont(new Font("MV Boli", Font.BOLD, 16)); //set the font style
		lblText.setForeground(Application_Content.GREEN); //set the font color
		
		//add the component within the west panel
		panel_West_Layout.add(iconImage, BorderLayout.NORTH);
		panel_West_Layout.add(lblText, BorderLayout.CENTER);
		
		panel_West.add(panel_West_Layout);
		
		return panel_West;
	}
	
	private JPanel east_Panel() {
		JPanel east_Panel = new JPanel(new BorderLayout());
		east_Panel.setBackground(Application_Content.BLUE_30);
		east_Panel.setBorder(BorderFactory.createEmptyBorder(40,25,0,65));
		
		JPanel east_Panel_Layout = new JPanel(new MigLayout());
		east_Panel_Layout.setBackground(Application_Content.BLUE_30);
		
		//Initialize the login label 
		JLabel lblLoginText = new JLabel("Please Login Here");
		lblLoginText.setForeground(Application_Content.GREEN);
		lblLoginText.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblLoginText.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		east_Panel_Layout.add(lblLoginText,"wrap");
		
		//Initialize the user id label 
		JLabel lblUserID = new JLabel("Enter User ID: ");
		lblUserID.setForeground(Application_Content.GREEN);
		lblUserID.setFont(new Font("MV Boli", Font.BOLD, 13));
		east_Panel_Layout.add(lblUserID,"wrap");
		
		//Initialize the user id formatted text field
		JFormattedTextField txtUserID = new JFormattedTextField();
		txtUserID.setForeground(Application_Content.GREEN);
		txtUserID.setBackground(Application_Content.DEEP_BLUE);
		txtUserID.setFont(new Font("MV Boli", ~Font.BOLD, 11));
		txtUserID.setPreferredSize(new Dimension(230,35));
		txtUserID.setBorder(BorderFactory.createLineBorder(Application_Content.DEEP_BLUE));
		east_Panel_Layout.add(txtUserID,"wrap");
		
		//Initialize the password label
		JLabel lblPassword = new JLabel("Enter Password: ");
		lblPassword.setForeground(Application_Content.GREEN);
		lblPassword.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblPassword.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		east_Panel_Layout.add(lblPassword,"wrap");
		
		//Initialize the password field
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setForeground(Application_Content.GREEN);
		txtPassword.setBackground(Application_Content.DEEP_BLUE);
		txtPassword.setFont(new Font("MV Boli", ~Font.BOLD, 11));
		txtPassword.setPreferredSize(new Dimension(230,35));
		txtPassword.setBorder(BorderFactory.createLineBorder(Application_Content.DEEP_BLUE));
		east_Panel_Layout.add(txtPassword,"wrap");
		
		JButton loginButton = null;
		loginButton = buttonPanel(loginButton, "Login");
		east_Panel_Layout.add(loginButton,"split 2, center, gaptop 45");
		
		JButton cancelButton = null;
		cancelButton = buttonPanel(cancelButton, "Cancel");
		east_Panel_Layout.add(cancelButton, "gapleft 30");
		
		east_Panel.add(east_Panel_Layout);
		
		return east_Panel;
	}
	
	private JButton buttonPanel(JButton button, String buttonValue) {
		button = new JButton(buttonValue);
		button.setForeground(Application_Content.DEEP_BLUE);
		button.setBackground(Application_Content.GREEN);
		button.setBorder(BorderFactory.createLineBorder(Application_Content.GREEN));
		button.setFont(new Font("MV Boli", Font.BOLD, 16));
		button.setPreferredSize(new Dimension(100,30));
		return button;
	}
	
	private JLabel iconImage(String resourch) {
		JLabel iconLabel = new JLabel();
		try {
			//read the file from the components
			ImageIcon iconImage = new ImageIcon(resourch);
			Image img = iconImage.getImage();
			Image newImg = img.getScaledInstance(175, 125, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newImg);
			
			//add the icon image to the label
			iconLabel = new JLabel(newIcon);
			
		} catch (Exception e) {
			System.out.println("Could not found the sourch!");
			e.printStackTrace();
		}
		
		return iconLabel;
	}

	public static void main(String[] args) {
		new Login_Window();
	}
}
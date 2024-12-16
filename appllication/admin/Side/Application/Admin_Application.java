package admin.Side.Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import app_Content.Application_Content;
//import application.Interaction.Interaction;


public class Admin_Application extends JFrame{
	
//	static protected JButton btnButton;
//	static protected JLabel lblMesseage;
	
	private JPanel main_Panel;
	
	private final int X = 900, Y = 700;
	
	public Admin_Application() {
		//set the title for the application
		this.setTitle("Admin Appllication");
		
		//set the window able to close manually
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the window to visible
		this.setVisible(true);
		
		//defining the layout 
		main_Panel = new JPanel(new BorderLayout());
		
		//set the back ground color
		main_Panel.setBackground(Application_Content.MAIN_COLOR);
				
		JPanel dashboard_Panel1 = box_Panel("Account Balance", 1000);
		dashboard_Panel1.setPreferredSize(new Dimension(160,70));
		
		JPanel main_Top_Panel = new JPanel(new FlowLayout());
		main_Top_Panel.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10)); //adding space between the panel
		main_Top_Panel.setBackground(Application_Content.MAIN_COLOR); //set the background color 
		main_Top_Panel.add(dashboard_Panel1); //added it to the top panel at the main frame
		
		//add the dash board panel at the north side in main panel
		main_Panel.add(main_Top_Panel,BorderLayout.NORTH);
		
		//add the to the frame 
		this.add(main_Panel);
				
		//set the size for the window
		this.setSize(new Dimension(X,Y));
		
		//the the location to the center
		this.setLocationRelativeTo(null);
						
		//unable to resize the window
		this.setResizable(false);
	}
	
	private JPanel box_Panel(String title, double value) {
		JPanel account_Dashboard_Panel = new JPanel(new BorderLayout());
		account_Dashboard_Panel.setBackground(Application_Content.PANEL_BLUE);
//		account_Dashboard_Panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JLabel dashboard_Title = new JLabel(title);
		dashboard_Title.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		dashboard_Title.setForeground(Application_Content.TEXT_COLOR);
		dashboard_Title.setFont(new Font("MV Boli",Font.BOLD,16));
		
		JLabel dashboard_Capacity = new JLabel("$ " + value);
		dashboard_Capacity.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		dashboard_Capacity.setForeground(Color.WHITE);
		dashboard_Capacity.setFont(new Font("MV Boli",~Font.BOLD,16));
		
		account_Dashboard_Panel.add(dashboard_Title, BorderLayout.NORTH);
		account_Dashboard_Panel.add(dashboard_Capacity, BorderLayout.CENTER);
		
		return account_Dashboard_Panel;
	}
	
	public static void main(String[] args) {
		new Admin_Application();
	}
}

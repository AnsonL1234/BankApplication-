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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import app_Content.Application_Content;
import dataType.User;
import rearSide.DatabaseManagementSystem;
//import application.Interaction.Interaction;


public class Admin_Application extends JFrame{
	
//	static protected JButton btnButton;
//	static protected JLabel lblMesseage;
	
	//variable for the main window
	private JPanel main_Panel;
	private JMenuBar main_Menu;
	
	//variable for main center panel
	private JTable center_Table;
	private DefaultTableModel center_Model;
	
	//defining the size of the window by X and Y
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
		main_Panel.setBackground(Application_Content.DARK_BLUE);
		
		//defining the menu bar and call the method for menu
		main_Menu = menu_Setting();
		this.setJMenuBar(main_Menu);
				
		//defining the menu bar and call the method for main panel
		main_Panel = main_Top_Panel();
		main_Panel = main_Centre_Panel();
		
		//defining the button
		JButton selectButton = null, updateButton = null;
		updateButton = buttonAction(updateButton, "Update");
		selectButton = buttonAction(selectButton, "Select");
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Application_Content.DARK_BLUE);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
		
		//add to the bottom panel of the windows
		bottomPanel.add(updateButton);
		bottomPanel.add(selectButton);
		
		//add to the main panel and locate in south position
		main_Panel.add(bottomPanel, BorderLayout.SOUTH);
		
//		selectButton.addActionListener(this);
		
		//add it to the main window
		this.add(main_Panel);
				
		//set the size for the window
		this.setSize(new Dimension(X,Y));
		
		//the the location to the center
		this.setLocationRelativeTo(null);
						
		//unable to resize the window
		this.setResizable(false);
	}
	
	private JMenuBar menu_Setting() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Application_Content.DARK_BLUE);
//		menuBar.setBorder(BorderFactory.createLineBorder(Application_Content.DARK_BLUE));
		menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JButton registerButton = new JButton("Register");
		registerButton.setBackground(Application_Content.ORANGE_50);
		registerButton.setForeground(Application_Content.DARK_BLUE);
//		registerButton.setBorder(BorderFactory.createLineBorder(Application_Content.ORANGE_50));
		registerButton.setFont(new Font("MV Boli",~Font.BOLD,14));
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBackground(Application_Content.ORANGE_50);
		removeButton.setForeground(Application_Content.DARK_BLUE);
//		removeButton.setBorder(BorderFactory.createLineBorder(Application_Content.ORANGE_50));
		removeButton.setFont(new Font("MV Boli",~Font.BOLD,14));
		
		JTextField txtSearchUser = new JTextField("Enter the user name and ID you wish to search...");
		txtSearchUser.setBackground(Application_Content.LIGHT_ORANGE);
		txtSearchUser.setForeground(Application_Content.LIGHT_BLUE);
		txtSearchUser.setBorder(BorderFactory.createLineBorder(Application_Content.LIGHT_ORANGE));
		txtSearchUser.setFont(new Font("MV Boli",~Font.BOLD,14));
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(Application_Content.ORANGE_50);
		searchButton.setForeground(Application_Content.DARK_BLUE);
//		searchButton.setBorder(BorderFactory.createLineBorder(Application_Content.ORANGE_50));
		searchButton.setFont(new Font("MV Boli",~Font.BOLD,14));
		
		//adding action for the button
//		registerButton.addActionListener((ActionListener) this);
//		removeButton.addActionListener((ActionListener) this);
//		searchButton.addActionListener((ActionListener) this);
		
		Box box = Box.createHorizontalBox();
		box.add(registerButton);
		box.add(Box.createHorizontalStrut(5)); 
		box.add(removeButton);
		box.add(Box.createHorizontalStrut(20)); 
		box.add(txtSearchUser);
		box.add(Box.createHorizontalStrut(10)); 
		box.add(searchButton);
		box.add(Box.createHorizontalStrut(10));
		
		menuBar.add(box);
		
		return menuBar;
	}
	
	private JPanel main_Top_Panel() {
		JPanel dashboard_Panel1 = box_Panel("Account Balance ", "$", 1000000);
		dashboard_Panel1.setPreferredSize(new Dimension(165,70));
		
		JPanel dashboard_Panel2 = box_Panel("Net/Loss Profits ", "$", 1000);
		dashboard_Panel2.setPreferredSize(new Dimension(165,70));
		
		JPanel dashboard_Panel3 = box_Panel("Users Growth In %", "%", 25);
		dashboard_Panel3.setPreferredSize(new Dimension(165,70));
		
		JPanel dashboard_Panel4 = box_Panel("Loan Borrows", "$", 250000);
		dashboard_Panel4.setPreferredSize(new Dimension(165,70));
		
		JPanel dashboard_Panel5 = box_Panel("Blacklist Numbers", "Members ", 50);
		dashboard_Panel5.setPreferredSize(new Dimension(165,70));
		
		JPanel main_Top_Panel = new JPanel(new FlowLayout());
		main_Top_Panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 35, 10)); //adding space between the panel
		main_Top_Panel.setBackground(Application_Content.DARK_BLUE); //set the background color 
		main_Top_Panel.add(dashboard_Panel1); //added it to the top panel at the main frame
		main_Top_Panel.add(dashboard_Panel2);
		main_Top_Panel.add(dashboard_Panel3);
		main_Top_Panel.add(dashboard_Panel4);
		main_Top_Panel.add(dashboard_Panel5);
		
		//add the dash board panel at the north side in main panel
		main_Panel.add(main_Top_Panel,BorderLayout.NORTH);
		
		return main_Panel;
	}
	
	private JPanel box_Panel(String title, String label, double value) {
		JPanel Dashboard_Panel = new JPanel(new BorderLayout());
		Dashboard_Panel.setBackground(Application_Content.ORANGE_50);
//		account_Dashboard_Panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JLabel dashboard_Title = new JLabel(title);
		dashboard_Title.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		dashboard_Title.setForeground(Application_Content.DARK_BLUE);
		dashboard_Title.setFont(new Font("MV Boli",Font.BOLD,16));
		
		JLabel dashboard_Capacity = new JLabel(label + value);
		dashboard_Capacity.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		dashboard_Capacity.setForeground(Color.WHITE);
		dashboard_Capacity.setFont(new Font("MV Boli",~Font.BOLD,14));
		
		Dashboard_Panel.add(dashboard_Title, BorderLayout.NORTH);
		Dashboard_Panel.add(dashboard_Capacity, BorderLayout.CENTER);
		
		return Dashboard_Panel;
	}
	
	private JPanel main_Centre_Panel() {
		
		//table header
		String[] array_Header = {"User ID","First Name","Last Name","Email","Phone Number","DOB","Gender"}; 
		
		//defining the variable and set it to Grid Layout
		JPanel table_Panel = new JPanel();
		table_Panel.setBackground(Application_Content.DARK_BLUE);
		
		//defining the table model with header and insert it in table
		center_Model = new DefaultTableModel(array_Header,20);
		center_Table = new JTable(center_Model);
		
		//resize the table
		center_Table.setPreferredScrollableViewportSize(new Dimension(830,350));
		
		//set the color for the border, header and row in table
		center_Table.getTableHeader().setBackground(Application_Content.ORANGE_50);
		center_Table.getTableHeader().setForeground(Application_Content.DARK_BLUE);
		center_Table.getTableHeader().setFont(new Font("MV Boli", Font.BOLD, 14));
		
		//if the border is greater or equals to 1 then change the color
		if (center_Table.getRowCount() >= 1) {
			center_Table.setBackground(Application_Content.ORANGE_60);
			center_Table.setForeground(Application_Content.DARK_BLUE);
		}
		
		//set the color of the border layout to the dark blue color
		center_Table.getTableHeader().setBorder(BorderFactory.createLineBorder(Application_Content.DARK_BLUE));
		center_Table.setBorder(BorderFactory.createLineBorder(Application_Content.DARK_BLUE));
		
		//set the height of the row
		center_Table.setRowHeight(25);
		
		//set the table header unable to move
		center_Table.getTableHeader().setReorderingAllowed(false);
		
		//set the table as a single selection
		center_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//set the table as un-editable
		for (int i = 0; i < array_Header.length; i++) center_Table.setDefaultEditor(center_Table.getColumnClass(i), null);
		
		//set the table to create the row automatically once the new info has been insert
		center_Table.setAutoCreateRowSorter(rootPaneCheckingEnabled);
		
		//put all the components in the scroll pane
		JScrollPane scrollTable = new JScrollPane(center_Table);
		
		//add it to the table panel
		table_Panel.add(scrollTable);
		
		//add it to the main center panel
		main_Panel.add(table_Panel, BorderLayout.CENTER);
		
		return main_Panel;
	}
	
	private JButton buttonAction(JButton button, String value) {
		button = new JButton(value);
		button.setPreferredSize(new Dimension(115,40));
		button.setBackground(Application_Content.ORANGE_50);
		button.setForeground(Application_Content.DARK_BLUE);
		button.setFont(new Font("MV Boli", Font.BOLD,16));
//		button.addActionListener((ActionListener) this);
		return button;
	}
}

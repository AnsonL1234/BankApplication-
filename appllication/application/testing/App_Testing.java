package application.testing;

import javax.swing.SwingUtilities;

import admin.Side.Application.*;

public class App_Testing {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Admin_Application adminWindow = new Admin_Application();
			adminWindow.setLocationRelativeTo(null);
			adminWindow.setVisible(true);
		});
	}

}

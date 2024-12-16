package rearSide;

import java.sql.*;
import dataType.*;
import util.LinkedList;
import java.time.LocalDate;

public class DatabaseManagementSystem {
	
	//variable for access to the SQL database
	static private final String url = "jdbc:postgresql://localhost:5432/postgres";
	static private final String username = "postgres";
	static private final String password1 = "1001";
	
	//linked list
	private LinkedList<User> userList;
	
	public void getUserInfo() {
		
		this.userList = new LinkedList<>();
		
		String query = "SELECT user_ID, password, first_Name, last_Name, email, phone_Number, dob, gender FROM users";
		
		try (Connection connectDatabase = DriverManager.getConnection(url,username,password1)) {
			 connectDatabase.setAutoCommit(false);
			
			if (connectDatabase != null) {
				System.out.println("It have connect to the database successfully!");
				
				Statement databaseStatement = connectDatabase.createStatement();
				ResultSet databaseOutput = databaseStatement.executeQuery(query);
				
				while (databaseOutput.next()) {
					String ID = databaseOutput.getString("user_ID");
					String password1 = databaseOutput.getString("password");
					String firstName = databaseOutput.getString("first_Name");
					String lastName = databaseOutput.getString("last_Name");
					String email = databaseOutput.getString("email");
					String phoneNumber = databaseOutput.getString("phone_Number");
					Date dob = databaseOutput.getDate("dob");
					String gender = databaseOutput.getString("gender");
					
					//convert the date to local date
					LocalDate localDOB = dob.toLocalDate();
					
					User user = new User(ID,password1,firstName,lastName,email,phoneNumber,localDOB,gender);
					this.userList.add(user);
				}
				
				connectDatabase.commit();
				System.out.println(userList.toString());
			
			} 
		}catch (SQLException e) {
			System.out.println("Failed to connect to the database");
			e.printStackTrace();
			
		}
	}
	
	public void insertNewAccount(String user_ID, String password, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, String gender) {
		
		String insertQuery = "INSERT INTO users (user_ID, password, first_Name, last_Name, email, phone_Number, dob, gender) VALUEs (?,?,?,?,?,?,?,?)";
		
		try (Connection connectDatabase = DriverManager.getConnection(url,username,password1)) {
			PreparedStatement newAccount = connectDatabase.prepareStatement(insertQuery);
			
//			int i = 0;
			newAccount.setString(1, user_ID);
			newAccount.setString(2, password);
			newAccount.setString(3, firstName);
			newAccount.setString(4, lastName);
			newAccount.setString(5, email);
			newAccount.setString(6, phoneNumber);
			newAccount.setDate(7, Date.valueOf(dob));
			newAccount.setString(8, gender);
			
			int rowsAffected = newAccount.executeUpdate();
		    if (rowsAffected > 0) {
		        System.out.println("User added to the database successfully.");
		    } else {
		        System.out.println("User not added to the database.");
		    }
		} catch (SQLException e) {
			System.out.println("Failed to adding user to the database = " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public boolean isUserIDExists(String userID) {
	    try (Connection connection = DriverManager.getConnection(url,username,password1); 
	    	PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM Users WHERE user_ID = ?")) {
	    	
	        statement.setString(1, userID);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt(1) > 0; // Check if the count is greater than 0
	        }
	    } catch (SQLException e) {
	        System.err.println("Error checking user ID existence: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return false; // Default to false if there's an error
	}
}

package rearSide;

import java.sql.*;
import java.time.LocalDate;

import dataType.User;
import util.LinkedList;

public class UserManagementSystem {
	
	private DatabaseManagementSystem databaseSystem;
	private LinkedList<User> userList;
	private User user;
	
	//a method that adding the new user
	public void addBankUser(String user_ID, String password, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, String gender) {
		
		databaseSystem = new DatabaseManagementSystem();
		userList = new LinkedList<>();
		
		//user ID currently holding the id generator that check is the user exists
		user_ID = userIDGeneration(userList);
		
		//insert to the database
		databaseSystem.insertNewAccount(user_ID,password,firstName,lastName,email,phoneNumber,dob,gender);
		
		//added to the user define class
		user = new User(user_ID,password,firstName,lastName,email,phoneNumber,dob,gender);
		
		//added to the linked list
		userList.add(user);
		
		System.out.println("User List Size: " + userList.size());
	}
	
	//a private method that check is the user exists
	//because every user has a unit ID
	private boolean isUserExists(String user_ID,LinkedList<User> userList) {
		if (userList == null) {
	        System.out.println("userList is null.");
	        return false;
	    }
		
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			if(user.getUserID().equals(user_ID) || databaseSystem.isUserIDExists(user_ID)) {
				return true;
			}
		}

	    return false; 
	}
	
	//a private method that generate the user id between 1 to 99999
	private String userIDGeneration(LinkedList<User> userList) {
		String userID = "";
		
		do {
			int givenId = (int)(Math.random() * 99999) + 1;
			userID = "S" + givenId;
		} while (isUserExists(userID,userList));
		
		return userID;
	}
}

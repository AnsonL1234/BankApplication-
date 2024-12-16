package testing;

import java.sql.Date;
import java.time.LocalDate;

import dataType.User;
import rearSide.*;
import util.LinkedList;

public class FunctionTesting {
	
	private UserManagementSystem manageSystem;
	private DatabaseManagementSystem databaseManageSystem;
	
	static private LinkedList<User> userList;
	
	public FunctionTesting() {
		this.userList = new LinkedList<>();
		manageSystem = new UserManagementSystem();
		databaseManageSystem = new DatabaseManagementSystem();
		
		LocalDate date = LocalDate.of(2001, 02, 19);
		
//		manageSystem.addBankUser("S10002", "Anson1234","Anson","Ling","ansonl@gamil.com","0879917659",date,"Male");
//		System.out.println("The user has been added to the database successfully");
		databaseManageSystem.getUserInfo();
	}
	
	public static void main(String[] args) {
		
		new FunctionTesting();
		
	}
}

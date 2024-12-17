package dataType;

import java.sql.Date;
import java.time.LocalDate;

public class User {
	
	private String userID;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate dob;
	private String gender;
	
	public User(Object o) {

		this.userID = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
		this.dob = null;
		this.gender = "";
	}
	
	public User(String userID, String password, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, String gender) {

		this.userID = userID;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.gender = gender;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean equals(Object o) {
		
		User e = (User) o;
		if (this.userID.equals(e.getUserID())) 
			return true;
		else 
			return false;	
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", gender=" + gender
				+ "]\n";
	}
}

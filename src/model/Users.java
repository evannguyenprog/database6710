package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Users {
	
	private String email;
	private String firstName;
	private String lastName;
	private String birthday;
	private double ppsBalance;
	
	
	public Users() {
    }
	
	public Users(String email, String firstName, String lastName, String birthday, double ppsBalance) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.ppsBalance = ppsBalance;
		
	}
	public Users(String firstName, String lastName, String birthday, double ppsBalance) {
		this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.ppsBalance = ppsBalance;
        
    }
    

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public double getPpsBalance() {
		return ppsBalance;
	}
	public void setPpsBalance(double ppsBalance) {
		this.ppsBalance = ppsBalance;
	}
	
	
	
}

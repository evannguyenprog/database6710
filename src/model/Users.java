package model;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String birthday;
	private String address;
	private double ppsBalance;
	private double dollarBalance;
	
	public Users() {
    }
	public Users(int id) {
        this.id = id;
    }
	public Users(int id, String email, String firstName, String lastName, String birthday, String address, double ppsBalance, double dollarBalance) {
		this(email, firstName, lastName, birthday, address, ppsBalance, dollarBalance);
		this.id = id;
	}
	public Users(String email, String firstName, String lastName, String birthday, String address, double ppsBalance, double dollarBalance) {
		this.email = email;
		this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.ppsBalance = ppsBalance;
        this.dollarBalance = dollarBalance;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPpsBalance() {
		return ppsBalance;
	}
	public void setPpsBalance(double ppsBalance) {
		this.ppsBalance = ppsBalance;
	}
	public double getDollarBalance() {
		return dollarBalance;
	}
	public void setDollarBalance(double dollarBalance) {
		this.dollarBalance = dollarBalance;
	}
	
	
}

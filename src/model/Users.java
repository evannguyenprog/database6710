package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Users {
	
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private Date birthday;
	private double ppsBalance;
	
	
	public Users() {
    }
	public Users(int id) {
        this.id = id;
    }
	public Users(int id, String email, String firstName, String lastName, Date birthday, double ppsBalance) {
		this(email, firstName, lastName, birthday, ppsBalance);
		this.id = id;
	}
	public Users(String email, String firstName, String lastName, Date birthday, double ppsBalance) {
		this.email = email;
		this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.ppsBalance = ppsBalance;
        
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public double getPpsBalance() {
		return ppsBalance;
	}
	public void setPpsBalance(double ppsBalance) {
		this.ppsBalance = ppsBalance;
	}
	
	
	
}

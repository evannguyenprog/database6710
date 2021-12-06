

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Users {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String birthday;
	private double ppsBalance;
	
	
	public Users(String receiving_user_email) {
		this.email = receiving_user_email;
    }
	
	public Users(String email, String password, String firstName, String lastName, String birthday, double ppsBalance) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.ppsBalance = ppsBalance;
		
	}
	public Users(String password, String firstName, String lastName, String birthday, double ppsBalance) {
		this.password = password;
		this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.ppsBalance = ppsBalance;
        
    }
    

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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

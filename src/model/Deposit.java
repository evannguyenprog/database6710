package model;

import java.util.Date;

public class Deposit {
	
	// 'deposit_id' is going to be the primary_key for 
	// Deposit table.
	private int deposit_id;
	// Foreign key referring to the "Id" in "Users" table.
	private String user_email;
	private double deposit_amount;
	private String deposit_date;
	
	// Constructors :
	public Deposit() {
		
	}
	
	public Deposit(int deposit_id, String user_email, double deposit_amount, String deposit_date) {
		this.deposit_id = deposit_id;
		this.user_email = user_email;
		this.deposit_amount = deposit_amount;
		this.deposit_date = deposit_date;
	}
	
	public Deposit(String user_email, double deposit_amount, String deposit_date) {
		this.user_email = user_email;
		this.deposit_amount = deposit_amount;
		this.deposit_date = deposit_date;
	}
	
	
	
	
	
	// Getters and Setters for setting and getting the values above :
	
	public String getDeposit_date() {
		return deposit_date;
	}
	public void setDeposit_date(String deposit_date) {
		this.deposit_date = deposit_date;
	}
	public int getDeposit_id() {
		return deposit_id;
	}
	public void setDeposit_id(int deposit_id) {
		this.deposit_id = deposit_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public double getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(double deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
		

}

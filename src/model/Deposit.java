package model;

import java.util.Date;

public class Deposit {
	
	// deposit_id is going to be the primary_key for 
	// Deposit table.
	int deposit_id;
	// Foreign key referring to the "Id" in "Users" table.
	int user_id;
	double deposit_amount;
	Date deposit_date;
	
	
	
	// Getters and Setters for setting and getting the values above :
	
	public Date getDeposit_date() {
		return deposit_date;
	}
	public void setDeposit_date(Date deposit_date) {
		this.deposit_date = deposit_date;
	}
	public int getDeposit_id() {
		return deposit_id;
	}
	public void setDeposit_id(int deposit_id) {
		this.deposit_id = deposit_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(double deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
		

}

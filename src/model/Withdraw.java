package model;

import java.util.Date;

public class Withdraw {
	
	// withdraw_id is going to be the Primary_key for 
	// "Withdraw" table.
	int withdraw_id;
	// user_id refers to the "Id" of the users present in 
	// the "Users" table.
	int user_id;
	// The amount a particular user withdraws in one go/transaction :
	double withdraw_amount;
	
	Date withdrawal_date;
	
	
	// Constructors for 'Withdraw' class :
	
	public Withdraw() {
    }
	
	public Withdraw(int user_id) {
        this.user_id = user_id;
    }
	
	public Withdraw(int withdraw_id, int user_id, double withdraw_amount, Date withdrawal_date) {
		this.withdraw_id = withdraw_id;
		this.user_id = user_id;
		this.withdraw_amount = withdraw_amount;
		this.withdrawal_date = withdrawal_date;
	}
	
	public Withdraw(int user_id, double withdraw_amount, Date withdrawal_date) {
		this.user_id = user_id;
		this.withdraw_amount = withdraw_amount;
		this.withdrawal_date = withdrawal_date;
	}
	
	
	
	// Getters and Setters for 'Withdraw' class :
	public Date getWithdrawal_date() {
		return withdrawal_date;
	}
	public void setWithdrawal_date(Date withdrawal_date) {
		this.withdrawal_date = withdrawal_date;
	}
	// Getters and Setters below for setting the values and getting them 
	// as needed.
	public int getWithdraw_id() {
		return withdraw_id;
	}
	public void setWithdraw_id(int withdraw_id) {
		this.withdraw_id = withdraw_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getWithdraw_amount() {
		return withdraw_amount;
	}
	public void setWithdraw_amount(double withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}
	

}

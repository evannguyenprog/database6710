package model;

import java.util.Date;

public class Withdraw {
	
	// withdraw_id is going to be the Primary_key for 
	// "Withdraw" table.
	private int withdraw_id;
	// user_email refers to the "email" of the users present in 
	// the "Users" table.
	private String user_email;
	// The amount a particular user withdraws in one go/transaction :
	private double withdraw_amount;
	
	private String withdrawal_date;
	
	
	// Constructors for 'Withdraw' class :
	
	public Withdraw() {
    }
	
	public Withdraw(String user_id) {
        this.user_email = user_id;
    }
	
	public Withdraw(int withdraw_id, String user_email, double withdraw_amount, String withdrawal_date) {
		this.withdraw_id = withdraw_id;
		this.user_email = user_email;
		this.withdraw_amount = withdraw_amount;
		this.withdrawal_date = withdrawal_date;
	}
	
	public Withdraw(String user_email, double withdraw_amount, String withdrawal_date) {
		this.user_email = user_email;
		this.withdraw_amount = withdraw_amount;
		this.withdrawal_date = withdrawal_date;
	}
	
	
	
	// Getters and Setters for 'Withdraw' class :
	public String getWithdrawal_date() {
		return withdrawal_date;
	}
	public void setWithdrawal_date(String withdrawal_date) {
		this.withdrawal_date = withdrawal_date;
	}
	
	public int getWithdraw_id() {
		return withdraw_id;
	}
	public void setWithdraw_id(int withdraw_id) {
		this.withdraw_id = withdraw_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_id(String user_email) {
		this.user_email = user_email;
	}
	public double getWithdraw_amount() {
		return withdraw_amount;
	}
	public void setWithdraw_amount(double withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}
	

}

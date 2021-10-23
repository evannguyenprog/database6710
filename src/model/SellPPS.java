package model;

import java.util.Date;

// PPS is sold to the special_user_root
public class SellPPS {
	
	// Primary_Key of the table :
	private int id;
	// The user who sells the PPS :
	private String user_email;
	// Number of PPS sold :
	private int number_pps_sold;
	// Date on which the PPS is sold :
	private String pps_sold_date;
	
    // Constructors :
	
	public SellPPS() {
		
	}
	
	public SellPPS(int id, String user_email, int number_pps_sold, String pps_sold) {
		this.id = id;
		this.user_email = user_email;
		this.number_pps_sold = number_pps_sold;
		this.pps_sold_date = pps_sold;
	}
	
	public SellPPS(String user_email, int number_pps_sold, String pps_sold) {
		this.user_email = user_email;
		this.number_pps_sold = number_pps_sold;
		this.pps_sold_date = pps_sold;
	}
		
	
	// Getters and Setters :

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getNumber_pps_sold() {
		return number_pps_sold;
	}

	public void setNumber_pps_sold(int number_pps_sold) {
		this.number_pps_sold = number_pps_sold;
	}

	public String getPps_sold_date() {
		return pps_sold_date;
	}

	public void setPps_sold_date(String pps_sold_date) {
		this.pps_sold_date = pps_sold_date;
	}

}

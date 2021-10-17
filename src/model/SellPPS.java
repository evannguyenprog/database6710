package model;

import java.util.Date;

// PPS is sold to the special_user_root
public class SellPPS {
	
	// Primary_Key of the table :
    int id;
	// The user who sells the PPS :
	int user_id;
	// Number of PPS sold :
	int number_pps_sold;
	// Date on which the PPS is sold :
	Date pps_sold_date;
	
    // Constructors :
	
	public SellPPS() {
		
	}
	
	public SellPPS(int id, int user_id, int number_pps_sold, Date pps_sold) {
		this.id = id;
		this.user_id = user_id;
		this.number_pps_sold = number_pps_sold;
		this.pps_sold_date = pps_sold;
	}
	
	public SellPPS(int user_id, int number_pps_sold, Date pps_sold) {
		this.user_id = user_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getNumber_pps_sold() {
		return number_pps_sold;
	}

	public void setNumber_pps_sold(int number_pps_sold) {
		this.number_pps_sold = number_pps_sold;
	}

	public Date getPps_sold_date() {
		return pps_sold_date;
	}

	public void setPps_sold_date(Date pps_sold_date) {
		this.pps_sold_date = pps_sold_date;
	}

}

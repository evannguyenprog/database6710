package model;

import java.util.Date;

// PPS is bought from the special_user_root.
public class BuyPPS {
	
	int id;
	
	int user_id;
	
	int number_pps_bought;
	
	Date pps_bought_date;
	
	
	// Constructors :
	
	public BuyPPS() {
		
	}
	
	public BuyPPS(int id, int user_id, int number_pps_bought, Date pps_bought_date) {
		this.id = id;
		this.user_id = user_id;
		this.number_pps_bought = number_pps_bought;
		this.pps_bought_date = pps_bought_date;
	}
	public BuyPPS(int user_id, int number_pps_bought, Date pps_bought_date) {
		this.user_id = user_id;
		this.number_pps_bought = number_pps_bought;
		this.pps_bought_date = pps_bought_date;
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

	public int getNumber_pps_bought() {
		return number_pps_bought;
	}

	public void setNumber_pps_bought(int number_pps_bought) {
		this.number_pps_bought = number_pps_bought;
	}

	public Date getPps_bought_date() {
		return pps_bought_date;
	}

	public void setPps_bought_date(Date pps_bought) {
		this.pps_bought_date = pps_bought;
	}
	
	

}

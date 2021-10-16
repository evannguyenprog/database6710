package model;

import java.util.Date;

// PPS is sold to the special_user_root
public class Sell_PPS {
	
    int id;
	
	int user_id;
	
	int number_pps_sold;
	
	Date pps_sold;

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

	public Date getPps_sold() {
		return pps_sold;
	}

	public void setPps_sold(Date pps_sold) {
		this.pps_sold = pps_sold;
	}

}

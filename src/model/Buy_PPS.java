package model;

import java.util.Date;

// PPS is bought from the special_user_root.
public class Buy_PPS {
	
	int id;
	
	int user_id;
	
	int number_pps_bought;
	
	Date pps_bought;

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

	public Date getPps_bought() {
		return pps_bought;
	}

	public void setPps_bought(Date pps_bought) {
		this.pps_bought = pps_bought;
	}
	
	

}

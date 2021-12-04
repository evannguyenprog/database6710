

import java.util.Date;

// PPS is bought from the special_user_root.
public class BuyPPS {
	
	private int id;
	
	private String user_email;
	
	private double number_pps_bought;
	
	private String pps_bought_date;
	
	
	// Constructors :
	
	public BuyPPS() {
		
	}
	
    public BuyPPS(String user_email) {
		this.user_email = user_email;
	}
	
	public BuyPPS(int id, String user_email, double number_pps_bought, String pps_bought_date) {
		this.id = id;
		this.user_email = user_email;
		this.number_pps_bought = number_pps_bought;
		this.pps_bought_date = pps_bought_date;
	}
	public BuyPPS(String user_email, double number_pps_bought, String pps_bought_date) {
		this.user_email = user_email;
		this.number_pps_bought = number_pps_bought;
		this.pps_bought_date = pps_bought_date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * @return the number_pps_bought
	 */
	public double getNumber_pps_bought() {
		return number_pps_bought;
	}

	/**
	 * @return the pps_bought_date
	 */
	public String getPps_bought_date() {
		return pps_bought_date;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * @param number_pps_bought the number_pps_bought to set
	 */
	public void setNumber_pps_bought(double number_pps_bought) {
		this.number_pps_bought = number_pps_bought;
	}

	/**
	 * @param pps_bought_date the pps_bought_date to set
	 */
	public void setPps_bought_date(String pps_bought_date) {
		this.pps_bought_date = pps_bought_date;
	}	
	
	
	
	

}

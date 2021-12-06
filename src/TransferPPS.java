

import java.util.Date;

// A user will be able to transfer PPS to another user.
public class TransferPPS {
    
	// 'id' below will be a primary_key. It is to be auto_incremented.
	private int id;
	
    private String transfering_user_email;
	
	private String receiving_user_email;
	
	private String transfer_date;
	
	private int number_pps_transfered;
	
	
	


	
	/**
	 * @return the number_pps_transfered
	 */
	public int getNumber_pps_transfered() {
		return number_pps_transfered;
	}

	/**
	 * @param number_pps_transfered the number_pps_transfered to set
	 */
	public void setNumber_pps_transfered(int number_pps_transfered) {
		this.number_pps_transfered = number_pps_transfered;
	}

	// Constructor defining :
	public TransferPPS(String receiving_user_email) {
		this.receiving_user_email = receiving_user_email;
		
	}
	
	public TransferPPS(int id, String transfering_user_email,  String receiving_user_email,   String transfer_date, int number_pps_transfered) {
		this.id = id;
		this.transfering_user_email = transfering_user_email;
		this.receiving_user_email = receiving_user_email;
		this.transfer_date = transfer_date;
		this.number_pps_transfered = number_pps_transfered;
	}
	
	public TransferPPS(String transfering_user_id,  String receiving_user_id,   String transfer_date, int number_pps_transfered) {
		this.transfering_user_email = transfering_user_id;
		this.receiving_user_email = receiving_user_id;
		this.transfer_date = transfer_date;
		this.number_pps_transfered = number_pps_transfered;
	}

	
	
	public TransferPPS(int number_pps_transfered2) {
		// TODO Auto-generated constructor stub
		this.number_pps_transfered = number_pps_transfered2;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the transfering_user_email
	 */
	public String getTransfering_user_email() {
		return transfering_user_email;
	}

	/**
	 * @return the receiving_user_email
	 */
	public String getReceiving_user_email() {
		return receiving_user_email;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param transfering_user_email the transfering_user_email to set
	 */
	public void setTransfering_user_email(String transfering_user_email) {
		this.transfering_user_email = transfering_user_email;
	}

	/**
	 * @param receiving_user_email the receiving_user_email to set
	 */
	public void setReceiving_user_email(String receiving_user_email) {
		this.receiving_user_email = receiving_user_email;
	}


	public String getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(String transfer_date) {
		this.transfer_date = transfer_date;
	}
	
	
	
}

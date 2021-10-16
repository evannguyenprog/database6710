package model;

import java.util.Date;

// A user will be able to transfer PPS to another user.
public class Transfer_PPS {
    
	int id;
	
	int transfering_user_id;
	
	int receiving_user_id;
	
	Date transfer_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransfering_user_id() {
		return transfering_user_id;
	}

	public void setTransfering_user_id(int transfering_user_id) {
		this.transfering_user_id = transfering_user_id;
	}

	public int getReceiving_user_id() {
		return receiving_user_id;
	}

	public void setReceiving_user_id(int receiving_user_id) {
		this.receiving_user_id = receiving_user_id;
	}

	public Date getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(Date transfer_date) {
		this.transfer_date = transfer_date;
	}
	
	
	
}

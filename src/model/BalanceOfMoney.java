package model;


// This particular class refers to the Balance_of_Money(i.e. Amount_Dollars) that
// each users possesses
public class BalanceOfMoney {
	
	// user_id is the (Id) referring to the "Users" table.
	// It is a Foreign_Key & could/would also be the Primary_Key
	// as it is going to be unique for every row in the table "Balance_of_Money"
	private String user_email;
	private double balance_in_dollars;
	
	
	// Constructors :

	public BalanceOfMoney() {
		
	}
	
	public BalanceOfMoney(String user_email, double balance_in_dollars) {
		this.user_email = user_email;
		this.balance_in_dollars = balance_in_dollars;
	}

	
	// Getters and Setters :
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * @return the balance_in_dollars
	 */
	public double getBalance_in_dollars() {
		return balance_in_dollars;
	}

	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * @param balance_in_dollars the balance_in_dollars to set
	 */
	public void setBalance_in_dollars(double balance_in_dollars) {
		this.balance_in_dollars = balance_in_dollars;
	}
			
    
}

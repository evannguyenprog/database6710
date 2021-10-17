package model;


// This particular class refers to the Balance_of_Money(i.e. Amount_Dollars) that
// each users possesses
public class BalanceOfMoney {
	
	// user_id is the (Id) referring to the "Users" table.
	// It is a Foreign_Key & could/would also be the Primary_Key
	// as it is going to be unique for every row in the table "Balance_of_Money"
	int user_id;
	double balance_in_dollars;
	
	
	// Constructors :

	public BalanceOfMoney() {
		
	}
	
	public BalanceOfMoney(int user_id, double balance_in_dollars) {
		this.user_id = user_id;
		this.balance_in_dollars = balance_in_dollars;
	}
	
	
	// Generating getters and setters :
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getBalance_in_dollars() {
		return balance_in_dollars;
	}
	public void setBalance_in_dollars(double balance_in_dollars) {
		this.balance_in_dollars = balance_in_dollars;
	}
	
	
	
    
}

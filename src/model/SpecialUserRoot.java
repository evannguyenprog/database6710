package model;

public class SpecialUserRoot {
	
	String id;
	
	double balance_of_money;
	
	int balance_of_pps;
	
	double price_of_pps;
	
	
	public SpecialUserRoot() {
		
	}
	
	public SpecialUserRoot(String id , double balance_of_money, int balance_of_pps, double price_of_pps) {
		this.id = id;
		this.balance_of_money = balance_of_money;
		this.balance_of_pps = balance_of_pps;
		this.price_of_pps = price_of_pps;
	}
	
	public SpecialUserRoot(double balance_of_money, int balance_of_pps, double price_of_pps) {
		this.balance_of_money = balance_of_money;
		this.balance_of_pps = balance_of_pps;
		this.price_of_pps = price_of_pps;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the balance_of_money
	 */
	public double getBalance_of_money() {
		return balance_of_money;
	}

	/**
	 * @return the balance_of_pps
	 */
	public int getBalance_of_pps() {
		return balance_of_pps;
	}

	/**
	 * @return the price_of_pps
	 */
	public double getPrice_of_pps() {
		return price_of_pps;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param balance_of_money the balance_of_money to set
	 */
	public void setBalance_of_money(double balance_of_money) {
		this.balance_of_money = balance_of_money;
	}

	/**
	 * @param balance_of_pps the balance_of_pps to set
	 */
	public void setBalance_of_pps(int balance_of_pps) {
		this.balance_of_pps = balance_of_pps;
	}

	/**
	 * @param price_of_pps the price_of_pps to set
	 */
	public void setPrice_of_pps(double price_of_pps) {
		this.price_of_pps = price_of_pps;
	}
	
	

}

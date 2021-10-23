package model;

public class Address {
	
	private String user_email;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	// Constructors :
	public Address() {
		
	}
	
	public Address(String user_email, String street, String city, String state, int zipcode) {
		this.user_email = user_email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public Address(String street, String city, String state, int zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	
	// Getters and Setters :
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	

}

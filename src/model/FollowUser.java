package model;

import java.util.Date;

public class FollowUser {
    
	// 'id' below would be the Primay_Key.
	private int id;
	// Below variable would be the user who is a follower(i.e. who's following other user(s))
	// It is also a foreign_key referring to the 'Id' column of 'Users' table.
	private String following_user_email;
	// Below variable would be the user who is getting followed.
	// It is also a foreign_key referring to the 'Id' column of 'Users' table.
	private String followed_user_email;
	// Date when the follow happens.
	private String followed_date;
	
	
	// Constructor :
	public FollowUser() {
		
	}
	
	public FollowUser(int id, String following_user_email, String followed_user_email, String followed_date) {
		this.id = id;
		this.following_user_email = following_user_email;
		this.followed_user_email = followed_user_email;
		this.followed_date = followed_date;
	}
	
	public FollowUser(String following_user_email, String followed_user_email, String followed_date) {
		this.following_user_email = following_user_email;
		this.followed_user_email = followed_user_email;
		this.followed_date = followed_date;
	}
	
	
	// Getters and Setters :
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFollowing_user_email() {
		return following_user_email;
	}
	public void setFollowing_user_email(String following_user_email) {
		this.following_user_email = following_user_email;
	}
	public String getFollowed_user_email() {
		return followed_user_email;
	}
	public void setFollowed_user_email(String followed_user_email) {
		this.followed_user_email = followed_user_email;
	}
	public String getFollowed_date() {
		return followed_date;
	}
	public void setFollowed_date(String followed_date) {
		this.followed_date = followed_date;
	}
	
	
}

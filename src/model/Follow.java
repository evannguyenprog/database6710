package model;

import java.util.Date;

public class Follow {
    
	// 'id' below would be the Primay_Key.
	int id;
	// Below variable would be the user who is a follower(i.e. who's following other user(s))
	// It is also a foreign_key referring to the 'Id' column of 'Users' table.
	int following_user_id;
	// Below variable would be the user who is getting followed.
	// It is also a foreign_key referring to the 'Id' column of 'Users' table.
	int followed_user_id;
	// Date when the follow happens.
	Date follow;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFollowing_user_id() {
		return following_user_id;
	}
	public void setFollowing_user_id(int following_user_id) {
		this.following_user_id = following_user_id;
	}
	public int getFollowed_user_id() {
		return followed_user_id;
	}
	public void setFollowed_user_id(int followed_user_id) {
		this.followed_user_id = followed_user_id;
	}
	public Date getFollow() {
		return follow;
	}
	public void setFollow(Date follow) {
		this.follow = follow;
	}
	
	
}

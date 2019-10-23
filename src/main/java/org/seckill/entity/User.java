package org.seckill.entity;

public class User {
	
	private String userName;
	private String userPassword;
	private int userId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", userId=" + userId + "]";
	}

	
}

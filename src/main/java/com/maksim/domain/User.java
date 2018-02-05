package com.maksim.domain;



public class User {

	private int userId;
	private String login;
	private String password;
	private String fullName;
	private String address;
	private String role;

	private boolean validUser;

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login= login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isValidUser() {
		return validUser;
	}

	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

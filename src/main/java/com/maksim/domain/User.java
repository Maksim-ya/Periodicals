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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (userId != user.userId) return false;
		if (validUser != user.validUser) return false;
		if (!login.equals(user.login)) return false;
		if (!password.equals(user.password)) return false;
		if (!fullName.equals(user.fullName)) return false;
		if (!address.equals(user.address)) return false;
		return role.equals(user.role);

	}

	@Override
	public int hashCode() {
		int result = userId;
		result = 31 * result + login.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + fullName.hashCode();
		result = 31 * result + address.hashCode();
		result = 31 * result + role.hashCode();
		result = 31 * result + (validUser ? 1 : 0);
		return result;
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

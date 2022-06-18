package com.practice.model.common;

public class JwtRequest {
	String username;
	String password;
	String mPin;

	public JwtRequest() {
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mPin
	 */
	public String getmPin() {
		return mPin;
	}

	/**
	 * @param mPin the mPin to set
	 */
	public void setmPin(String mPin) {
		this.mPin = mPin;
	}

	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", password=" + password + ", mPin=" + mPin + "]";
	}
}

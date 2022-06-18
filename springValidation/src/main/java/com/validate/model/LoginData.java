/**
 * 
 */
package com.validate.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author sameer
 *
 */
public class LoginData {

	/**
	 * 
	 */
	public LoginData() {
	}

	@NotBlank(message = "User Name can not be empty !!")
	@Size(min = 3, max = 12, message = "User Name Must be Between 3 - 12 charcaters")
	private String username;

	// @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid
	// Email !!")
//	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email !!")
//	private String email;
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@AssertTrue(message = "Must Agreed Terms And Condition")
	private boolean agreed;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the agreed
	 */
	public boolean isAgreed() {
		return agreed;
	}

	/**
	 * @param agreed the agreed to set
	 */
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "LoginData [username=" + username + ", email=" + email + ", agreed=" + agreed + "]";
	}
}

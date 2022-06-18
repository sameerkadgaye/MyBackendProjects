/**
 * 
 */
package com.email.model;

/**
 * @author sameer
 *
 */
public class EmailResponse {

	/**
	 * 
	 */
	public EmailResponse() {
	}

	private String token;

	/**
	 * @param token
	 */
	public EmailResponse(String token) {
		super();
		this.token = token;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "EmailResponse [token=" + token + "]";
	}
}

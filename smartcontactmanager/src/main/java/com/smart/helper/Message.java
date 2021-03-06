/**
 * 
 */
package com.smart.helper;

/**
 * @author sameer
 *
 */
public class Message {

	/**
	 * 
	 */
	public Message() {
	}

	private String content;
	private String type;

	/**
	 * @param content
	 * @param type
	 */
	public Message(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}

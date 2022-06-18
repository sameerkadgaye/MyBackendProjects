package com.practice.model.common;

import org.springframework.http.HttpStatus;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public class RequestResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	
	private HttpStatus httpStatus;
	
	private Object reponse;
	
	public RequestResponse(){
		
	}
	
	/**
	 * @param code
	 * @param msg
	 * @param httpStatus
	 * @param reponse
	 */
	public RequestResponse(int code, String msg, HttpStatus httpStatus, Object reponse) {
		super();
		this.code = code;
		this.msg = msg;
		this.httpStatus = httpStatus;
		this.reponse = reponse;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	// Overrides Exception's getMessage()
//    @Override
	public String getMessage() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public Object getResponse() {
		return reponse;
	}
	public void setResponse(Object response) {
		this.reponse = response;
	}
	
	
	
}

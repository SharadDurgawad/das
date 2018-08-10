package com.customer.account.model;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5967085285787504412L;
	private int statusCode;
	private String errorMessage;
	private Date timeStamp;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}

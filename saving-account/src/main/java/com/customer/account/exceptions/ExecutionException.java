package com.customer.account.exceptions;

import com.customer.account.configuration.BasicConfiguration;

/**
 * The ExecutionException class.
 */
public class ExecutionException extends RuntimeException {

	/** The constant serial version UID. */
	private static final long serialVersionUID = 5638828788015731856L;

	/** The error code. */
	private int errorCode;

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new object of {@link ExecutionException}
	 * 
	 * @param errorCode    the error code
	 * @param errorMessage the error message
	 */
	public ExecutionException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
/**
	 * Instantiates a new object of {@link ExecutionException}
	 * 
	 * @param errorCode    the error code
	 * @param errorMessage the error message
	 */
	public ExecutionException(BasicConfiguration configuration, int errorCode, String className, String propertyName, String value, String reason) {
		super(reason);
		this.errorCode = errorCode;		
		StringBuilder sb = new StringBuilder();
		sb.append(configuration.getStars());
		sb.append(configuration.getExecutionException());
		sb.append(configuration.getStars());
		sb.append(configuration.getClassName()).append(className);
		sb.append(configuration.getProperty()).append(propertyName);
		sb.append(configuration.getValue()).append(value);
		sb.append(configuration.getReason()).append(reason);
		sb.append(configuration.getStars());
		
		this.errorMessage = sb.toString();
	}
	/**
	 * Instantiates a new object of {@link ExecutionException}
	 * 
	 * @param errorMessage the error message
	 */
	public ExecutionException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code
	 * 
	 * @param errorCode the error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error message
	 * 
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message
	 * 
	 * @param errorMessage the error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "Error code: " + errorCode + " Message: " + errorMessage;
	}
}
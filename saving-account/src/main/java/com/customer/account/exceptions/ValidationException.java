package com.customer.account.exceptions;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.account.configuration.BasicConfiguration;

/**
 * The ValidationException class.
 */
public class ValidationException extends RuntimeException {
	
	/** The constant serial version UID. */
	private static final long serialVersionUID = 3963862317457294708L;

	/** The validation error message. */
	private String message;

	/**
	 * Instantiates a new object of {@link ValidationException}
	 * 
	 * @param message the validation error message
	 */
	public ValidationException(String message) {
		super(message);
		this.message = message;
	}
	
	/**
	 * 
	 * @param configuration Instance of BasicConfiguration
	 * @param className Name of the class for which validation failed.
	 * @param propertyName Name of the property which has invalid value.
	 * @param value Current value of the property.
	 * @param reason Reason for failed validataion.
	 */
	public ValidationException(BasicConfiguration configuration, String className, String propertyName, String value, String reason) {
		StringBuilder sb = new StringBuilder();
		sb.append(configuration.getStars());
		sb.append(configuration.getValidationFailed());
		sb.append(configuration.getStars());
		sb.append(configuration.getClassName()).append(className);
		sb.append(configuration.getProperty()).append(propertyName);
		sb.append(configuration.getValue()).append(value);
		sb.append(configuration.getReason()).append(reason);
		sb.append(configuration.getStars());
		this.message = sb.toString();
	}

	/**
	 * Gets the validation error message.
	 * 
	 * @return the validation error message.
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the validation error message.
	 * 
	 * @param message the validation error message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

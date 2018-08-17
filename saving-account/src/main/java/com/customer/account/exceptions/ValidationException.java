package com.customer.account.exceptions;

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

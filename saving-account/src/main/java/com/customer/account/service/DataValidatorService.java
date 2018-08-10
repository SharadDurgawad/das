package com.customer.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.customer.account.exceptions.ValidationException;
import com.customer.account.model.CustomerDetails;
import com.customer.account.validator.CustomerValidator;

/**
 * The class DataValidator validates the data has required information in
 * correct format.
 */
@Service
public class DataValidatorService {

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(DataValidatorService.class);

	/** The customer validator. */
	private CustomerValidator customerValidator;

	public DataValidatorService() {
		this.customerValidator = new CustomerValidator();
	}

	/**
	 * Checks whether the input data has valid entry or not.
	 * 
	 * @param customerDetails the customer object
	 * 
	 * @return true if all the fields have valid entry, otherwise false.
	 */
	public boolean isDataValidForCreate(CustomerDetails customerDetails) {
		if (customerDetails != null) {
			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isCustomerValidForCreate(customerDetails);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error("All the fields are not valid :: {}", errors);
				throw new ValidationException(errors);
			}
			logger.debug("All the fields are valid for customer ID {}.", customerDetails.getCustomerId());
			return true;
		}
		throw new ValidationException("Customer cannot be null or empty.");
	}
	
	public boolean isIdValidForCreate(CustomerDetails customerDetails) {
		if (customerDetails != null && customerDetails.getCustomerId() != null) {
			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isIdValidForCreate(customerDetails);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error("All the fields are not valid :: {}", errors);
				throw new ValidationException(errors);
			}
			logger.debug("All the fields are valid for customer ID {}.", customerDetails.getCustomerId());
			return true;
		}
		throw new ValidationException("Customer and its ID cannot be null or empty.");
	}

	/**
	 * Checks whether the input data has valid entry or not.
	 * 
	 * @param customerDetails the customer object
	 * 
	 * @return true if all the fields have valid entry, otherwise false.
	 */
	public boolean isDataValidForUpdate(CustomerDetails customerDetails) {
		if (customerDetails != null && customerDetails.getCustomerId() != null) {

			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isCustomerValidForUpdate(customerDetails);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error("All the fields are not valid :: {}", errors);
				throw new ValidationException(errors);
			}
			logger.debug("All the fields are valid for customer ID {}.", customerDetails.getCustomerId());
			return true;
		}
		throw new ValidationException("Customer and its ID cannot be null or empty.");
	}
}
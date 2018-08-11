package com.customer.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.account.exceptions.ValidationException;
import com.customer.account.helper.CustomerValidatorHelper;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;

/**
 * The class DataValidator validates the data has required information in
 * correct format.
 */
@Service
public class DataValidatorServiceImpl implements DataValidatorService {

	private static final Logger logger = LoggerFactory.getLogger(DataValidatorServiceImpl.class);

	@Autowired
	private CustomerValidatorHelper customerValidator;

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
				logger.error(ApplicationConstants.INVALID_FIELD_MESSAGE, errors);
				throw new ValidationException(errors);
			}
			logger.debug(ApplicationConstants.VALID_FIELD_MESSAGE, customerDetails.getCustomerId());
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
				logger.error(ApplicationConstants.INVALID_FIELD_MESSAGE, errors);
				throw new ValidationException(errors);
			}
			logger.debug(ApplicationConstants.VALID_FIELD_MESSAGE, customerDetails.getCustomerId());
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
				logger.error(ApplicationConstants.INVALID_FIELD_MESSAGE, errors);
				throw new ValidationException(errors);
			}
			logger.debug(ApplicationConstants.VALID_FIELD_MESSAGE, customerDetails.getCustomerId());
			return true;
		}
		throw new ValidationException("Customer and its ID cannot be null or empty.");
	}
}
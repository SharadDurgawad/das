package com.customer.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.account.configuration.BasicConfiguration;
import com.customer.account.exceptions.ValidationException;
import com.customer.account.helper.CustomerValidatorHelper;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;
import com.customer.account.utility.CommonUtil;

/**
 * The class DataValidator validates the data has required information in
 * correct format.
 */
@Service
public class DataValidatorServiceImpl implements DataValidatorService {

	@Autowired
	private BasicConfiguration configuration;
	
	private static final Logger logger = LoggerFactory.getLogger(DataValidatorServiceImpl.class);
	private static final String allFieldsInValid = "All the fields are not valid :: {}"; 
	private static final String allFieldsValid = "All the fields are valid for customer ID {}.";

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
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		if (customerDetails != null) {
			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isCustomerValid(customerDetails, ApplicationConstants.CREATE);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error(allFieldsInValid, errors);
				throw new ValidationException(errors);
			}
			logger.debug(allFieldsValid, customerDetails.getCustomerId());
			logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
			return true;
		}
		throw new ValidationException("Customer cannot be null or empty.");
	}

	public boolean isIdValidForCreate(CustomerDetails customerDetails) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		if (customerDetails != null && customerDetails.getCustomerId() != null) {
			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isIdValidForCreate(customerDetails);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error(allFieldsInValid, errors);
				throw new ValidationException(errors);
			}
			logger.debug(allFieldsValid, customerDetails.getCustomerId());
			logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
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
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		if (customerDetails != null && customerDetails.getCustomerId() != null) {

			// Check the validity of each field.
			List<String> validationErrors = customerValidator.isCustomerValid(customerDetails, ApplicationConstants.UPDATE);
			if (validationErrors != null && !validationErrors.isEmpty()) {
				String errors = validationErrors.stream().collect(Collectors.joining(", "));
				customerValidator.emptyValidationErrorList();
				logger.error(allFieldsInValid, errors);
				throw new ValidationException(errors);
			}
			logger.debug(allFieldsValid, customerDetails.getCustomerId());
			logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
			return true;
		}
		throw new ValidationException("Customer and its ID cannot be null or empty.");
	}
}
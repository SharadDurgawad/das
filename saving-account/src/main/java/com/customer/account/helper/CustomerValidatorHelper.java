package com.customer.account.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.customer.account.model.AddressDetails;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;
import com.customer.account.utility.CommonUtil;
import com.customer.account.utility.DateUtil;

@Component
public class CustomerValidatorHelper {

	private List<String> validationErrors = new ArrayList<>();

	public List<String> isCustomerValid(CustomerDetails customer, String operation) {
		if ("U".equalsIgnoreCase(operation)) {
			validateAccountNumber(customer.getAccountNumber());
			validateCustomerId(customer.getCustomerId());
		}
		validateUniqueId(customer.getUniqueId());
		CommonUtil.validateField("First Name ", customer.getCustFirstName(), true, validationErrors);
		CommonUtil.validateField("Middle Name", customer.getCustMiddleName(), true, validationErrors);
		CommonUtil.validateField("Last Name", customer.getCustLastName(), true, validationErrors);
		validateEmailId(customer.getEmailId());
		validateDOB(customer.getDateOfBirth());
		CommonUtil.validateField("Phone Number", customer.getPhoneNumber(), false, validationErrors);
		validateGender(customer.getGender());
		validateAddress(customer.getAddressDetails());
		return validationErrors;

	}

	public List<String> isIdValidForCreate(CustomerDetails customer) {
		validateAccountNumber(customer.getAccountNumber());
		validateCustomerId(customer.getCustomerId());
		validateUniqueId(customer.getUniqueId());
		return validationErrors;

	}

	private void validateCustomerId(String customerId) {
		if ((ObjectUtils.isEmpty(customerId))) {
			validationErrors.add("Account Number" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateUniqueId(String uniqueId) {
		if (ObjectUtils.isEmpty(uniqueId)) {
			validationErrors.add("uniqueId" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	public void emptyValidationErrorList() {
		validationErrors.clear();
	}

	private void validateAccountNumber(String accountNumber) {
		if (accountNumber == null) {
			validationErrors.add("Account Number" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateAddress(AddressDetails addressDetails) {
		if (addressDetails != null) {
			CommonUtil.validateField("City", addressDetails.getCity(), true, validationErrors);
			CommonUtil.validateField("State", addressDetails.getState(), true, validationErrors);
			CommonUtil.validateField("Country", addressDetails.getCountry(), true, validationErrors);
			CommonUtil.validateField("Subdivision", addressDetails.getSubdivision(), false, validationErrors);
			CommonUtil.validateField("Address Line1", addressDetails.getLine1(), false, validationErrors);
			CommonUtil.validateField("Address Line2", addressDetails.getLine2(), false, validationErrors);
		} else {
			validationErrors.add("Address" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateGender(String gender) {
		if (gender != null) {
			if (StringUtils.isEmpty(gender)) {
				validationErrors.add("Provide gender as 'Male', 'Female' or 'Transgender'");
			}
		} else {
			validationErrors.add("Gender" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateDOB(String date) {
		if (date == null) {
			validationErrors.add("dob" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		} else if (StringUtils.isEmpty(DateUtil.getValidDateString(date))) {
			validationErrors.add("dob : " + ApplicationConstants.INVALID_DOB_ERROR);
		}
	}

	private void validateEmailId(String emailId) {
		if (StringUtils.isNotEmpty(emailId)) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pattern = Pattern.compile(emailRegex);
			if (!pattern.matcher(emailId).matches()) {
				validationErrors.add("Email ID is not valid");
			}
		}
	}

}

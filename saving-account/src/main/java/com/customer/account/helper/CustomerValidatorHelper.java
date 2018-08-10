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
import com.customer.account.utility.DateUtil;

@Component
public class CustomerValidatorHelper {

	private List<String> validationErrors = new ArrayList<>();

	public List<String> isCustomerValidForCreate(CustomerDetails customer) {
		validateFirstName(customer.getCustFirstName());
		validateMiddleName(customer.getCustMiddleName());
		validateLastName(customer.getCustLastName());
		validateEmailId(customer.getEmailId());
		validateDOB(customer.getDateOfBirth());
		validatePhoneNumber(customer.getPhoneNumber());
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
		if ((null == customerId && ObjectUtils.isEmpty(customerId))) {
			validationErrors.add("Account Number" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateUniqueId(String uniqueId) {
		if (null == uniqueId && ObjectUtils.isEmpty(uniqueId)) {
			validationErrors.add("uniqueId" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	public List<String> isCustomerValidForUpdate(CustomerDetails customer) {
		validateAccountNumber(customer.getAccountNumber());
		validateUniqueId(customer.getUniqueId());
		validateCustomerId(customer.getCustomerId());
		validateFirstName(customer.getCustFirstName());
		validateMiddleName(customer.getCustMiddleName());
		validateLastName(customer.getCustLastName());
		validateEmailId(customer.getEmailId());
		validateDOB(customer.getDateOfBirth());
		validatePhoneNumber(customer.getPhoneNumber());
		validateGender(customer.getGender());
		validateAddress(customer.getAddressDetails());
		return validationErrors;

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
			validateCity(addressDetails.getCity());
			validateState(addressDetails.getState());
			validateCountry(addressDetails.getCountry());
			validateSubdivision(addressDetails.getSubdivision());
			validateLine1(addressDetails.getLine1());
			validateLine2(addressDetails.getLine2());
		} else {
			validationErrors.add("Address" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateLine2(String line2) {
		if (StringUtils.isEmpty(line2)) {
			validationErrors.add("Line2" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateLine1(String line1) {
		if (StringUtils.isEmpty(line1)) {
			validationErrors.add("Line1" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateSubdivision(String subdivision) {
		if (StringUtils.isNotEmpty(subdivision)) {
			if (!StringUtils.isAlpha(subdivision)) {
				validationErrors.add("Sub division" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		}
	}

	private void validateCountry(String country) {
		if (StringUtils.isNotEmpty(country)) {
			if (!StringUtils.isAlpha(country)) {
				validationErrors.add("Country" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		} else {
			validationErrors.add("Country" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateState(String state) {
		if (StringUtils.isNotEmpty(state)) {
			if (!StringUtils.isAlpha(state)) {
				validationErrors.add("State" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		} else {
			validationErrors.add("State" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		}
	}

	private void validateCity(String city) {
		if (StringUtils.isNotEmpty(city)) {
			if (!StringUtils.isAlpha(city)) {
				validationErrors.add("City" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		} else {
			validationErrors.add("City" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
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

	private void validatePhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
			validationErrors.add("Phone number cannot be empty");
		}
	}

	private void validateMiddleName(String custMiddleName) {
		if (StringUtils.isNotEmpty(custMiddleName)) {
			if (!StringUtils.isAlpha(custMiddleName)) {
				validationErrors.add("Middle name" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
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

	private void validateFirstName(String custFirstName) {
		if (StringUtils.isEmpty(custFirstName)) {
			validationErrors.add("First name" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		} else {
			if (!StringUtils.isAlpha(custFirstName)) {
				validationErrors.add("First name" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		}
	}

	private void validateLastName(String custLastName) {
		if (StringUtils.isEmpty(custLastName)) {
			validationErrors.add("Last name" + ApplicationConstants.EMPTY_ERROR_MESSAGE);
		} else {
			if (!StringUtils.isAlpha(custLastName)) {
				validationErrors.add("Last name" + ApplicationConstants.ALPHA_ERROR_MESSAGE);
			}
		}
	}
}

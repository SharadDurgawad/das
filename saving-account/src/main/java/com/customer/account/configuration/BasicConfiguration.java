package com.customer.account.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("constants")
public class BasicConfiguration {
	private String starts;
	private String ends;
	private String customer;
	private String containsInvalidData;
	private String missingOrInvalidData;
	private String notFound;
	private String unMatched;
	private String stars;
	private String property;
	private String value;
	private String reason;
	private String isNull;
	private String validationFailed;
	private String className;
	private String  allFieldsValid;
	private String  allFieldsNotValid;
	private String invalidData;
	private String alreadyExists;
	private String executionException;
	private String idMismatched;
	private String validatingUser;
	private String actualValue;
	private String invalidDob;
	private String alphabetOnly;
	private String nullOrempty;
	private String userNotFound;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStarts() {
		return starts;
	}

	public void setStarts(String starts) {
		this.starts = starts;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getContainsInvalidData() {
		return containsInvalidData;
	}

	public void setContainsInvalidData(String containsInvalidData) {
		this.containsInvalidData = containsInvalidData;
	}

	public String getMissingOrInvalidData() {
		return missingOrInvalidData;
	}

	public void setMissingOrInvalidData(String missingOrInvalidData) {
		this.missingOrInvalidData = missingOrInvalidData;
	}

	public String getNotFound() {
		return notFound;
	}

	public void setNotFound(String notFound) {
		this.notFound = notFound;
	}

	public String getUnMatched() {
		return unMatched;
	}

	public void setUnMatched(String unMatched) {
		this.unMatched = unMatched;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getValidationFailed() {
		return validationFailed;
	}

	public void setValidationFailed(String validationFailed) {
		this.validationFailed = validationFailed;
	}

	public String getAllFieldsValid() {
		return allFieldsValid;
	}

	public void setAllFieldsValid(String allFieldsValid) {
		this.allFieldsValid = allFieldsValid;
	}

	public String getAllFieldsNotValid() {
		return allFieldsNotValid;
	}

	public void setAllFieldsNotValid(String allFieldsNotValid) {
		this.allFieldsNotValid = allFieldsNotValid;
	}

	public String getInvalidData() {
		return invalidData;
	}

	public void setInvalidData(String invalidData) {
		this.invalidData = invalidData;
	}

	public String getAlreadyExists() {
		return alreadyExists;
	}

	public void setAlreadyExists(String alreadyExists) {
		this.alreadyExists = alreadyExists;
	}

	public String getExecutionException() {
		return executionException;
	}

	public void setExecutionException(String executionException) {
		this.executionException = executionException;
	}

	public String getIdMismatched() {
		return idMismatched;
	}

	public void setIdMismatched(String idMismatched) {
		this.idMismatched = idMismatched;
	}

	public String getValidatingUser() {
		return validatingUser;
	}

	public void setValidatingUser(String validatingUser) {
		this.validatingUser = validatingUser;
	}

	public String getUserNotFound() {
		return userNotFound;
	}

	public void setUserNotFound(String userNotFound) {
		this.userNotFound = userNotFound;
	}

	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	public String getInvalidDob() {
		return invalidDob;
	}

	public void setInvalidDob(String invalidDob) {
		this.invalidDob = invalidDob;
	}

	public String getAlphabetOnly() {
		return alphabetOnly;
	}

	public void setAlphabetOnly(String alphabetOnly) {
		this.alphabetOnly = alphabetOnly;
	}

	public String getNullOrempty() {
		return nullOrempty;
	}

	public void setNullOrempty(String nullOrempty) {
		this.nullOrempty = nullOrempty;
	}

}

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

}

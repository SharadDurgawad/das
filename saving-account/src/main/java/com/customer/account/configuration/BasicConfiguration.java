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
}

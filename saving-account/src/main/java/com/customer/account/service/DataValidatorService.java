package com.customer.account.service;

import com.customer.account.model.CustomerDetails;

public interface DataValidatorService {

	public boolean isDataValidForCreate(CustomerDetails customerDetails);
	public boolean isIdValidForCreate(CustomerDetails customerDetails);
	public boolean isDataValidForUpdate(CustomerDetails customerDetails);
	
}

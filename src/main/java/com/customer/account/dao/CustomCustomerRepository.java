package com.customer.account.dao;

import java.util.List;

import com.customer.account.model.CustomerDetails;

public interface CustomCustomerRepository {

	public List<CustomerDetails> retriveCustomer(String customerId);
	public List<CustomerDetails> retriveAllCustomer();
}

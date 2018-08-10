package com.customer.account.service;

import java.util.List;

import com.customer.account.model.CustomerDetails;

public interface AccountService {
	public Object create(Object object);
	public Object update(Object object,Object customerId);
	public Object retrive(Object object);
	public List<CustomerDetails> retriveAll();
	public Object remove(Object object);
}

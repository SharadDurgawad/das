package com.customer.account.service;

import java.util.List;

public interface AccountService {
	public <T> Object create(Object object);
	public <T> Object update(Object object,Object customerId);
	public <T> Object retrive(Object object);
	public List<?> retriveAll();
	public <T> Object remove(Object object);
}

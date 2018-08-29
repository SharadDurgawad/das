package com.customer.account.service;

import java.util.List;

import com.customer.account.model.CustomerDetails;
/**
 * Interface to be used by any service class which implements CRUD methods.
 * @author ashfaq
 *
 * @param <T> Type of the your entity.
 */
public interface BaseService<T> {
	public T create(T object);
	public T update(T entity,String customerId);
	public T retrive(String id);
	public List<T> retriveAll();
	public T remove(String id);
}

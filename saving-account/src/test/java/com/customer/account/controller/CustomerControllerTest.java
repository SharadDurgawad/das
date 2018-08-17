package com.customer.account.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.CustomerDetails;
import com.customer.account.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerService accountService;
	
	@Test
	public void createCustomerTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		Mockito.when(accountService.create(customerDetails)).thenReturn(customerDetails);
		ResponseEntity<CustomerDetails> response = customerController.createCustomer(customerDetails);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void getCustomerTest() {
		 String customerId = "535345";
		 CustomerDetails customerDetails = new CustomerDetails();
		 customerDetails.setAccountNumber("5476574");
		 Mockito.when(accountService.retrive(customerId)).thenReturn(customerDetails);
		 ResponseEntity<CustomerDetails> response = customerController.getCustomer(customerId);
		 Assert.assertNotNull(response);
	}
	
	@Test(expected = ExecutionException.class)
	public void getCustomerTestException() {
		 String customerId = "535345";
		 CustomerDetails customerDetails = new CustomerDetails();
		 Mockito.when(accountService.retrive(customerId)).thenReturn(customerDetails);
		 customerController.getCustomer(customerId);
	}
	
	@Test
	public void getAllCustomerDetailsTest() {
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		Mockito.when(accountService.retriveAll()).thenReturn(customerDetailsList);
		ResponseEntity<List<CustomerDetails>> response  = customerController.getAllCustomerDetails();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void updateCustomerTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		String customerId = "42424";
		Mockito.when(accountService.update(customerDetails,customerId)).thenReturn(customerDetails);
		ResponseEntity<CustomerDetails> response = customerController.updateCustomer(customerDetails, customerId);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void removeCustomerTest() {
		String customerId = "342342";
		CustomerDetails customerDetails = new CustomerDetails();
		Mockito.when(accountService.remove(customerId)).thenReturn(customerDetails);
		ResponseEntity<CustomerDetails> response = customerController.removeCustomer(customerId);
		Assert.assertNotNull(response);
	}

}

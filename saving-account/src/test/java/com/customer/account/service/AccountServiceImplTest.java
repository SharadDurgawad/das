package com.customer.account.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.account.dao.CustomCustomerRepository;
import com.customer.account.dao.CustomerRepository;
import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.AddressDetails;
import com.customer.account.model.CustomerDetails;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceImplTest {
	
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomCustomerRepository customCustomerRepository;
	
	@Mock
	private DataValidatorServiceImpl dataValidator;
	
	@Test
	public void createTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		Object object = customerDetails;
		Mockito.when(dataValidator.isDataValidForCreate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(customerRepository.saveAndFlush(customerDetails)).thenReturn(customerDetails);
		Mockito.when(dataValidator.isIdValidForCreate(customerDetails)).thenReturn(Boolean.TRUE);
		CustomerDetails response = accountServiceImpl.create(object);
		Assert.assertNotNull(response);
		
		
	}
	
	@Test(expected = ExecutionException.class)
	public void createTestNull() {
		accountServiceImpl.create(null);
	}
	
	@Test(expected = ExecutionException.class)
	public void createTestInvalidData() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		Mockito.when(dataValidator.isDataValidForCreate(customerDetails)).thenReturn(Boolean.TRUE);
		accountServiceImpl.create(customerDetails);
	}
	
	private void getCustomerDetails(CustomerDetails customerDetails) {
		customerDetails.setAccountNumber("432432424");
		customerDetails.setCustFirstName("SampleFirstName");
		customerDetails.setCustLastName("SampleLastName");
		customerDetails.setCustMiddleName("sampleLastName");
		customerDetails.setCustomerId("123456789");
		customerDetails.setDateOfBirth("12/12/2000");
		customerDetails.setEmailId("someone@gmail.com");
		customerDetails.setGender("Male");
		customerDetails.setIsActive("true");
		customerDetails.setPhoneNumber("4324234254");
		customerDetails.setUniqueId("123123");
	}
	
	private void getCustomerAddress(AddressDetails addressDetails) {
		addressDetails.setCity("somecity");
		addressDetails.setCountry("somecountry");
		addressDetails.setLine1("addressline1");
		addressDetails.setLine2("addressline2");
		addressDetails.setLine3("addressline3");
		addressDetails.setPostalCode(231231);
		addressDetails.setState("somestate");
		addressDetails.setSubdivision("somesubdivion");
		addressDetails.setCustomerId("342323");
	}
	
	@Test
	public void updateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		Mockito.when(customerRepository.existsById(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(dataValidator.isDataValidForUpdate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(dataValidator.isIdValidForCreate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(customerRepository.saveAndFlush(customerDetails)).thenReturn(customerDetails);
		CustomerDetails details = accountServiceImpl.update(customerDetails, "123456789");
		Assert.assertNotNull(details);
	}
	
	@Test(expected = ExecutionException.class)
	public void updateTestInvalidData() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		Mockito.when(customerRepository.existsById(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(dataValidator.isDataValidForUpdate(customerDetails)).thenReturn(Boolean.FALSE);
		Mockito.when(dataValidator.isIdValidForCreate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(customerRepository.saveAndFlush(customerDetails)).thenReturn(customerDetails);
		accountServiceImpl.update(customerDetails, "123456789");
	}
	
	@Test(expected = ExecutionException.class)
	public void updateTestInvalidId() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		Mockito.when(customerRepository.existsById(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(dataValidator.isDataValidForUpdate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(dataValidator.isIdValidForCreate(customerDetails)).thenReturn(Boolean.FALSE);
		Mockito.when(customerRepository.saveAndFlush(customerDetails)).thenReturn(customerDetails);
		accountServiceImpl.update(customerDetails, "42342");
	}
	
	@Test
	public void retriveTest() {
		String customerId = "42342342";
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<CustomerDetails> customerList = new ArrayList<>();
		customerList.add(customerDetails);
		Mockito.when(customerRepository.existsById(customerId)).thenReturn(Boolean.TRUE);
		Mockito.when(customCustomerRepository.retriveCustomer(customerId)).thenReturn(customerList);
		CustomerDetails details = accountServiceImpl.retrive(customerId);
		Assert.assertNotNull(details);		
	}
	
	@Test(expected = ExecutionException.class)
	public void retriveExistsId() {
		String customerId = "42342342";
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<CustomerDetails> customerList = new ArrayList<>();
		customerList.add(customerDetails);
		Mockito.when(customerRepository.existsById(customerId)).thenReturn(Boolean.FALSE);
		Mockito.when(customCustomerRepository.retriveCustomer(customerId)).thenReturn(customerList);
		accountServiceImpl.retrive(customerId);
	}
	
	@Test
	public void retriveAllTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<CustomerDetails> customerList = new ArrayList<>();
		customerList.add(customerDetails);
		Mockito.when(customCustomerRepository.retriveAllCustomer()).thenReturn(customerList);
		Object response = accountServiceImpl.retriveAll();
		Assert.assertNotNull(response);
	}
	
	@Test(expected = ExecutionException.class)
	public void retriveAllException() {
		List<CustomerDetails> customerList = new ArrayList<>();
		Mockito.when(customCustomerRepository.retriveAllCustomer()).thenReturn(customerList);
		Object response = (Object)accountServiceImpl.retriveAll();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void removeTest() {
		String customerId = "432424";
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<CustomerDetails> customerList = new ArrayList<>();
		customerList.add(customerDetails);
		Mockito.when(dataValidator.isDataValidForUpdate(customerDetails)).thenReturn(Boolean.TRUE);
		Mockito.when(customerRepository.existsById(customerId)).thenReturn(Boolean.TRUE);
		Mockito.when(customCustomerRepository.retriveCustomer(customerId)).thenReturn(customerList);
		CustomerDetails response  = accountServiceImpl.remove(customerId);
		Assert.assertNotNull(response);
	}
}

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

import com.customer.account.exceptions.ValidationException;
import com.customer.account.helper.CustomerValidatorHelper;
import com.customer.account.model.AddressDetails;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DataValidatorServiceImplTest {
	
	@InjectMocks
	private DataValidatorServiceImpl dataValidatorService;
	@Mock
	private CustomerValidatorHelper customerValidator;

	@Test
	public void isDataValidForCreateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		Mockito.when(customerValidator.isCustomerValid(customerDetails, ApplicationConstants.CREATE)).thenReturn(validationErrors);
		Boolean response = dataValidatorService.isDataValidForCreate(customerDetails);
		Assert.assertNotNull(response);
	}
	
	@Test(expected= ValidationException.class)
	public void isDataValidForCreateErrors() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		validationErrors.add("404");
		Mockito.when(customerValidator.isCustomerValid(customerDetails, ApplicationConstants.CREATE)).thenReturn(validationErrors);
		dataValidatorService.isDataValidForCreate(customerDetails);
	}
	
	@Test(expected = ValidationException.class)
	public void isDataValidForCreateNull() {
		CustomerDetails customerDetails = null;
		dataValidatorService.isDataValidForCreate(customerDetails);
	}
	
	@Test
	public void isIdValidForCreateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		Mockito.when(customerValidator.isIdValidForCreate(customerDetails)).thenReturn(validationErrors);
		Boolean response = dataValidatorService.isIdValidForCreate(customerDetails);
		Assert.assertNotNull(response);
	}
	
	@Test(expected= ValidationException.class)
	public void isIdValidForCreateError() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		validationErrors.add("404");
		Mockito.when(customerValidator.isIdValidForCreate(customerDetails)).thenReturn(validationErrors);
		dataValidatorService.isIdValidForCreate(customerDetails);
	}
	
	@Test(expected = ValidationException.class)
	public void isIdValidForCreateNull() {
		CustomerDetails customerDetails = null;
		dataValidatorService.isIdValidForCreate(customerDetails);
	}
	
	@Test
	public void isDataValidForUpdateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		Mockito.when(customerValidator.isCustomerValid(customerDetails, ApplicationConstants.UPDATE)).thenReturn(validationErrors);
		Boolean response = dataValidatorService.isDataValidForUpdate(customerDetails);
		Assert.assertNotNull(response);
	}
	
	@Test(expected= ValidationException.class)
	public void isDataValidForUpdateError() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		List<String> validationErrors = new ArrayList<>();
		validationErrors.add("404");
		Mockito.when(customerValidator.isCustomerValid(customerDetails, ApplicationConstants.UPDATE)).thenReturn(validationErrors);
		dataValidatorService.isDataValidForUpdate(customerDetails);
	}
	
	@Test(expected = ValidationException.class)
	public void isDataValidForUpdateNull() {
		CustomerDetails customerDetails = null;
		dataValidatorService.isDataValidForUpdate(customerDetails);
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
}

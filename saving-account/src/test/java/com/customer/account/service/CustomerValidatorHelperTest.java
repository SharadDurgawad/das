package com.customer.account.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.account.helper.CustomerValidatorHelper;
import com.customer.account.model.AddressDetails;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;

@RunWith(MockitoJUnitRunner.class)
public class CustomerValidatorHelperTest {
	
	@InjectMocks
	private CustomerValidatorHelper customerValidatorHelper;
	
	@Test
	public void isCustomerValidForCreateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.CREATE);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isCustomerValidForCreateNull() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = null;
		getCustomerDetailsNull(customerDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.CREATE);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isCustomerValidForCreateAddress() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerAddressNull(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.CREATE);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isCustomerValidForCreateAddressNull() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = null;
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.CREATE);
		Assert.assertNotNull(response);
	}
	

	@Test
	public void isCustomerValidForCreateNotAlpha() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetailsNotAlpha(customerDetails);
		getCustomerAddressNotAlpha(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.CREATE);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isIdValidForCreateTest() {
		CustomerDetails customer = new CustomerDetails();
		customer.setAccountNumber("4324234");
		customer.setCustomerId("4234234");
		customer.setUniqueId("564754345");
		List<String> response = customerValidatorHelper.isIdValidForCreate(customer);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isIdValidForCreateNull() {
		CustomerDetails customer = new CustomerDetails();
		customer.setAccountNumber(null);
		customer.setCustomerId(null);
		customer.setUniqueId(null);
		List<String> response = customerValidatorHelper.isIdValidForCreate(customer);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void isCustomerValidForUpdateTest() {
		CustomerDetails customerDetails = new CustomerDetails();
		AddressDetails addressDetails = new AddressDetails();
		getCustomerDetails(customerDetails);
		getCustomerAddress(addressDetails);
		customerDetails.setAddressDetails(addressDetails);
		List<String> response = customerValidatorHelper.isCustomerValid(customerDetails,ApplicationConstants.UPDATE);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void emptyValidationErrorListTest() {
		customerValidatorHelper.emptyValidationErrorList();
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
	
	private void getCustomerDetailsNull(CustomerDetails customerDetails) {
		customerDetails.setAccountNumber(null);
		customerDetails.setCustFirstName(null);
		customerDetails.setCustLastName(null);
		customerDetails.setCustMiddleName(null);
		customerDetails.setCustomerId(null);
		customerDetails.setDateOfBirth(null);
		customerDetails.setEmailId(null);
		customerDetails.setGender("");
		customerDetails.setIsActive(null);
		customerDetails.setPhoneNumber(null);
		customerDetails.setUniqueId(null);
	}
	
	private void getCustomerDetailsNotAlpha(CustomerDetails customerDetails) {
		customerDetails.setAccountNumber("fsfd-4242");
		customerDetails.setCustFirstName("fsfd-4242");
		customerDetails.setCustLastName("fsfd-4242");
		customerDetails.setCustMiddleName("fsfd-4242");
		customerDetails.setCustomerId("fsfd-4242");
		customerDetails.setDateOfBirth("fsfd-4242");
		customerDetails.setEmailId("fsfd-4242");
		customerDetails.setGender("fsfd-4242");
		customerDetails.setIsActive("fsfd-4242");
		customerDetails.setPhoneNumber("fsfd-4242");
		customerDetails.setUniqueId("fsfd-4242");
	}
	
	private void getCustomerAddressNull(AddressDetails addressDetails) {
		addressDetails.setCity(null);
		addressDetails.setCountry(null);
		addressDetails.setLine1(null);
		addressDetails.setLine2(null);
		addressDetails.setLine3(null);
		addressDetails.setPostalCode(0);
		addressDetails.setState(null);
		addressDetails.setSubdivision(null);
		addressDetails.setCustomerId(null);
	}
	

	private void getCustomerAddressNotAlpha(AddressDetails addressDetails) {
		addressDetails.setCity("fsfd-4242");
		addressDetails.setCountry("fsfd-4242");
		addressDetails.setLine1("fsfd-4242");
		addressDetails.setLine2("fsfd-4242");
		addressDetails.setLine3("fsfd-4242");
		addressDetails.setPostalCode(0);
		addressDetails.setState("fsfd-4242");
		addressDetails.setSubdivision("fsfd-4242");
		addressDetails.setCustomerId("fsfd-4242");
	}
}

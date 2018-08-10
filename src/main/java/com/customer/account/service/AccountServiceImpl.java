package com.customer.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.customer.account.dao.CustomCustomerRepository;
import com.customer.account.dao.CustomerRepository;
import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.AccountDetails;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomCustomerRepository customCustomerRepository;
	
	@Autowired
	private DataValidatorService dataValidator;
	
	@Override
	public CustomerDetails create(Object object) {
		logger.debug("create::Start");
		CustomerDetails customerDetails = null;
		AccountDetails accountDetails = new AccountDetails();
		CustomerDetails details = null ;
		customerDetails = (CustomerDetails) object;
		if (!ObjectUtils.isEmpty(object) && dataValidator.isDataValidForCreate(customerDetails)) {
				generateAccountDetails(customerDetails, accountDetails);
				setCustomerFields(customerDetails, accountDetails);
				if(!customerRepository.existsById(customerDetails.getCustomerId())) {
					if(dataValidator.isIdValidForCreate(customerDetails))
						details =  customerRepository.saveAndFlush(customerDetails);
					else
						throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),
								"Customer '" + customerDetails.getCustomerId() + "' does not have valid data.");
				}else {
					throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),
							"Customer '" + customerDetails.getCustomerId() + "' already Exists.");
				}
		}else {
			logger.error("Customer details are not present or invalid data provided.");
			throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),
					"Customer details are not present or invalid data provided.");
		}
		logger.debug("create::End");
		return details;
	}
	
	private void setCustomerFields(CustomerDetails customerDetails,AccountDetails accountDetails) {
		customerDetails.setAccountNumber(accountDetails.getAccountNumber());
		customerDetails.setCustomerId(accountDetails.getCustomerId());
		customerDetails.getAddressDetails().setCustomerId(accountDetails.getCustomerId());
		customerDetails.setIsActive(String.valueOf(Boolean.TRUE));
		customerDetails.setGender(String.valueOf(customerDetails.getGender().toString()));
	}
	
	private void generateAccountDetails(CustomerDetails customerDetails,AccountDetails accountDetails) {
		long minAccountNo = 000000000000L;
		long maxAccountNo = 999999999999L;
		long randomAccountNumber = ThreadLocalRandom.current().nextLong(minAccountNo, maxAccountNo + 1);
		
		
		long minCustomer = 00000000L;
		long maxCustomer = 99999999L;
		long randomCustomerId = ThreadLocalRandom.current().nextLong(minCustomer, maxCustomer + 1);
		
		long minUniqueId = 0000000000L;
		long maxUniqueId = 9999999999L;
		long randomUniqueId = ThreadLocalRandom.current().nextLong(minUniqueId, maxUniqueId + 1);
		
		
		accountDetails.setAccountNumber(String.valueOf(randomAccountNumber));
		accountDetails.setCustomerId(String.valueOf(randomCustomerId));
		customerDetails.setUniqueId(String.valueOf(randomUniqueId));
	}
	
	@Override
	public CustomerDetails update(Object object,Object customerId) {
		logger.debug("update::Start");
		CustomerDetails customerDet;
		CustomerDetails customerDetails = null;
		customerDetails = (CustomerDetails) object;
		if(!ObjectUtils.isEmpty(customerDetails) && customerRepository.existsById((String) customerId) && dataValidator.isDataValidForUpdate(customerDetails)) {
			if(customerId.equals(customerDetails.getCustomerId()) && dataValidator.isIdValidForCreate(customerDetails)){
				customerDet = customerRepository.saveAndFlush(customerDetails);
			}else {
				throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),"Customer " + customerId + " does not match with update body");
			}
		}else {
			throw new ExecutionException(HttpStatus.NOT_FOUND.value(),"Customer " + customerId + " not found in the system");
		}
		logger.debug("update::End");
		return customerDet;
	}

	@Override
	public CustomerDetails retrive(Object object) {
		logger.debug("retrive::Start");
		String customerId = (String) object;
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		if (customerRepository.existsById(customerId)) {
			customerDetailsList = customCustomerRepository.retriveCustomer(customerId);
		}else {
			throw new ExecutionException(HttpStatus.NOT_FOUND.value(),
					"Customer " + customerId + " not found in the system");
		}
		logger.debug("retrive::End");
		return !CollectionUtils.isEmpty(customerDetailsList)?customerDetailsList.get(ApplicationConstants.ZERO):null;
	}

	@Override
	public List<CustomerDetails> retriveAll() {
		logger.debug("retriveAll::Start");
		List<CustomerDetails> customerDetailsList = new ArrayList<>();
		customerDetailsList = (List<CustomerDetails>) customCustomerRepository.retriveAllCustomer();
		if (!CollectionUtils.isEmpty(customerDetailsList)) {
			logger.debug("retriveAll::End");
			return customerDetailsList;
		}else {
			throw new ExecutionException(HttpStatus.NOT_FOUND.value(),
					"No Acount details found in the system");
		}
	}

	@Override
	public CustomerDetails remove(Object object) {
		logger.debug("remove::Start");
		CustomerDetails customerDetails = null;
		if(!ObjectUtils.isEmpty(object)) {
			String customerId =  (String) object;
			customerDetails = retrive(customerId);
			if(dataValidator.isDataValidForUpdate(customerDetails)) {
				customerDetails.setIsActive(String.valueOf(Boolean.FALSE));
				customerRepository.saveAndFlush(customerDetails);
				customerDetails = retrive(customerId);
			}
		}
		logger.debug("remove::End");
		return customerDetails;
	}
	
	
	

}

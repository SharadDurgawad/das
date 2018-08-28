package com.customer.account.service;

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

import com.customer.account.configuration.BasicConfiguration;
import com.customer.account.dao.CustomCustomerRepository;
import com.customer.account.dao.CustomerRepository;
import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.AccountDetails;
import com.customer.account.model.CustomerDetails;
import com.customer.account.utility.ApplicationConstants;
import com.customer.account.utility.CommonUtil;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomCustomerRepository customCustomerRepository;

	@Autowired
	private DataValidatorServiceImpl dataValidator;

	@Autowired
	private BasicConfiguration configuration;

	@Override
	public CustomerDetails create(Object object) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		CustomerDetails customerDetails = null;
		AccountDetails accountDetails = new AccountDetails();
		CustomerDetails details = null;
		customerDetails = (CustomerDetails) object;
		if (!ObjectUtils.isEmpty(object) && dataValidator.isDataValidForCreate(customerDetails)) {
			generateAccountDetails(customerDetails, accountDetails);
			setCustomerFields(customerDetails, accountDetails);
			if (!customerRepository.existsById(customerDetails.getCustomerId())) {
				if (dataValidator.isIdValidForCreate(customerDetails))
					details = customerRepository.saveAndFlush(customerDetails);
				else
					throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),
							configuration.getInvalidData() + " for " + ApplicationConstants.CUSTOMER_MESSAGE
									+ ApplicationConstants.SPACE + customerDetails.getCustomerId());
			} else {
				throw new ExecutionException(HttpStatus.BAD_REQUEST.value(),
						ApplicationConstants.CUSTOMER_MESSAGE + ApplicationConstants.SPACE
								+ customerDetails.getCustomerId() + configuration.getAlreadyExists());
			}
		} else {
			logger.error(configuration.getInvalidData());
			throw new ExecutionException(HttpStatus.BAD_REQUEST.value(), configuration.getInvalidData());
		}
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return details;
	}

	private void setCustomerFields(CustomerDetails customerDetails, AccountDetails accountDetails) {
		customerDetails.setAccountNumber(accountDetails.getAccountNumber());
		customerDetails.setCustomerId(accountDetails.getCustomerId());
		customerDetails.getAddressDetails().setCustomerId(accountDetails.getCustomerId());
		customerDetails.setIsActive(String.valueOf(Boolean.TRUE));
		customerDetails.setGender(String.valueOf(customerDetails.getGender()));
	}

	private void generateAccountDetails(CustomerDetails customerDetails, AccountDetails accountDetails) {
		long randomAccountNumber = CommonUtil.getRandomNumber();
		long randomCustomerId = CommonUtil.getRandomNumber();

		accountDetails.setAccountNumber(String.valueOf(randomAccountNumber));
		accountDetails.setCustomerId(String.valueOf(randomCustomerId));
	}

	@Override
	public CustomerDetails update(Object object, Object customerId) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		CustomerDetails customerDet;
		CustomerDetails customerDetails = null;
		customerDetails = (CustomerDetails) object;
		if (!ObjectUtils.isEmpty(customerDetails) && customerRepository.existsById((String) customerId)
				&& dataValidator.isDataValidForUpdate(customerDetails)) {
			if (customerId.equals(customerDetails.getCustomerId())
					&& dataValidator.isIdValidForCreate(customerDetails)) {
				customerDet = customerRepository.saveAndFlush(customerDetails);
			} else {
				throw new ExecutionException(configuration, HttpStatus.BAD_REQUEST.value(),
						CustomerDetails.class.getSimpleName(), "customerId", customerId.toString(),
						configuration.getIdMismatched());
			}
		} else {
			throw new ExecutionException(configuration, HttpStatus.NOT_FOUND.value(),
					CustomerDetails.class.getSimpleName(), "customerId", customerId.toString(),
					configuration.getNotFound());
		}
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return customerDet;
	}

	@Override
	public CustomerDetails retrive(Object object) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		String customerId = (String) object;
		List<CustomerDetails> customerDetailsList;
		if (customerRepository.existsById(customerId)) {
			customerDetailsList = customCustomerRepository.retriveCustomer(customerId);
		} else {
			throw new ExecutionException(configuration, HttpStatus.NOT_FOUND.value(),
					CustomerDetails.class.getSimpleName(), "customerId", customerId,
					configuration.getNotFound());
		}
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return !CollectionUtils.isEmpty(customerDetailsList) ? customerDetailsList.get(ApplicationConstants.ZERO)
				: null;
	}

	@Override
	public List<CustomerDetails> retriveAll() {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		List<CustomerDetails> customerDetailsList;
		customerDetailsList = customCustomerRepository.retriveAllCustomer();
		if (!CollectionUtils.isEmpty(customerDetailsList)) {
			logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
			return customerDetailsList;
		} else {
			throw new ExecutionException(configuration, HttpStatus.NOT_FOUND.value(),
					CustomerDetails.class.getSimpleName(), null, null, configuration.getNotFound());
		}
	}

	@Override
	public CustomerDetails remove(Object object) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		CustomerDetails customerDetails = null;
		if (!ObjectUtils.isEmpty(object)) {
			String customerId = (String) object;
			customerDetails = retrive(customerId);
			if (dataValidator.isDataValidForUpdate(customerDetails)) {
				customerDetails.setIsActive(String.valueOf(Boolean.FALSE));
				customerRepository.saveAndFlush(customerDetails);
				customerDetails = retrive(customerId);
			}
		}
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return customerDetails;
	}

}

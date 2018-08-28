package com.customer.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.account.configuration.BasicConfiguration;
import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.CustomerDetails;
import com.customer.account.service.CustomerService;
import com.customer.account.utility.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customers")
@Api(tags = "Customer Api")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService accountService;
	
	@Autowired
	private BasicConfiguration configuration;
	
	@PostMapping
	@ApiOperation(value = "Create Customer", notes = "Create new customer bank account.")
	public ResponseEntity<CustomerDetails> createCustomer(@RequestBody CustomerDetails customerDetails) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		HttpHeaders responseHeaders = new HttpHeaders();
		CustomerDetails details = (CustomerDetails) accountService.create(customerDetails);
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return new ResponseEntity<>(details, responseHeaders,HttpStatus.CREATED);
	}

	@GetMapping(value = "/{customerId}")
	@ApiOperation(value = "Retrive customer with {customerId}", notes = "Retrive particular customer details with provided customer Id")
	public ResponseEntity<CustomerDetails> getCustomer(@PathVariable String customerId) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		HttpHeaders responseHeaders = new HttpHeaders();
		CustomerDetails customerDetails = (CustomerDetails) accountService.retrive(customerId);
		if(ObjectUtils.isEmpty(customerDetails) || StringUtils.isEmpty(customerDetails.getAccountNumber())) {
		throw new ExecutionException(HttpStatus.NOT_FOUND.value(),
				"Customer " + customerId + " not found in the system");
		}
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return new ResponseEntity<>(customerDetails, responseHeaders,HttpStatus.OK);
		
	}

	@GetMapping
	@ApiOperation(value = "Get all Active Customer", notes = "Get all active customers from Bank.")
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		HttpHeaders responseHeaders = new HttpHeaders();
		List<CustomerDetails> customerDetailsList = accountService.retriveAll();
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return new ResponseEntity<>(customerDetailsList, responseHeaders,HttpStatus.OK);
	}

	@PutMapping(value = "/{customerId}")
	@ApiOperation(value = "update customer with {customerId}", notes = "update particular customer details with provided customer Id")
	public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody CustomerDetails customerDetails,@PathVariable String customerId) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		HttpHeaders responseHeaders = new HttpHeaders();
		CustomerDetails details = (CustomerDetails) accountService.update(customerDetails,customerId);
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return new ResponseEntity<>(details, responseHeaders,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{customerId}")
	@ApiOperation(value = "Delete customer with {customerId}", notes = "Delete particular customer with provided customer Id")
	public ResponseEntity<CustomerDetails> removeCustomer(@PathVariable String customerId) {
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getStarts()));
		HttpHeaders responseHeaders = new HttpHeaders();
		CustomerDetails customerDetails = (CustomerDetails) accountService.remove(customerId);
		logger.debug(CommonUtil.getCallingClassAndMethodName(configuration.getEnds()));
		return new ResponseEntity<>(customerDetails, responseHeaders,HttpStatus.NO_CONTENT);
	}
}

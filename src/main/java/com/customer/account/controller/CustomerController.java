package com.customer.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.account.exceptions.ExecutionException;
import com.customer.account.model.CustomerDetails;
import com.customer.account.service.AccountService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<CustomerDetails> createCustomer(@RequestBody CustomerDetails customerDetails) {
		logger.debug("createCustomer :: Start");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		CustomerDetails details = (CustomerDetails) accountService.create(customerDetails);
		logger.debug("createCustomer :: End");
		return new ResponseEntity<CustomerDetails>(details, responseHeaders,HttpStatus.CREATED);
	}

	@GetMapping(value = "/{customerId}")
	public ResponseEntity<CustomerDetails> getCustomer(@PathVariable String customerId) {
		logger.debug("getCustomer :: Start");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		CustomerDetails customerDetails = (CustomerDetails) accountService.retrive(customerId);
		if(ObjectUtils.isEmpty(customerDetails))
		throw new ExecutionException(HttpStatus.NOT_FOUND.value(),
				"Customer " + customerId + " not found in the system");
		logger.debug("getCustomer :: End");
		return new ResponseEntity<CustomerDetails>(customerDetails, responseHeaders,HttpStatus.OK);
		
	}

	@GetMapping
	public ResponseEntity<List<CustomerDetails>> getAllCustomerDetails() {
		logger.debug("getAllCustomerDetails :: Start");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		@SuppressWarnings("unchecked")
		List<CustomerDetails> customerDetailsList = (List<CustomerDetails>) accountService.retriveAll();
		logger.debug("getAllCustomerDetails :: End");
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsList, responseHeaders,HttpStatus.OK);
	}

	@PutMapping(value = "/{customerId}")
	public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody CustomerDetails customerDetails,@PathVariable String customerId) {
		logger.debug("updateCustomer :: Start");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		CustomerDetails details = (CustomerDetails) accountService.update(customerDetails,customerId);
		logger.debug("updateCustomer :: End");
		return new ResponseEntity<CustomerDetails>(details, responseHeaders,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{customerId}")
	public ResponseEntity<CustomerDetails> removeCustomer(@PathVariable String customerId) {
		logger.debug("removeCustomer :: Start");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		CustomerDetails customerDetails = (CustomerDetails) accountService.remove(customerId);
		logger.debug("removeCustomer :: End");
		return new ResponseEntity<CustomerDetails>(customerDetails, responseHeaders,HttpStatus.NO_CONTENT);
	}
}

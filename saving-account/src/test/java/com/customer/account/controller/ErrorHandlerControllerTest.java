package com.customer.account.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import com.customer.account.exceptions.ExecutionException;
import com.customer.account.exceptions.ValidationException;
import com.customer.account.model.ExceptionResponse;

@RunWith(MockitoJUnitRunner.class)
public class ErrorHandlerControllerTest {

	@InjectMocks
	private ErrorHandlerController errorHandlerController;
	
	@Test
	public void restClientExceptionHandlerTest(){
		RestClientException clientException = new RestClientException("No Data");
		ResponseEntity<ExceptionResponse> response = errorHandlerController.restClientExceptionHandler(clientException);
		Assert.assertNotNull(response);
	}
	
	/*@Test
	public void businessValidationExceptionHandlerTest() {
		RestClientException clientException = new RestClientException("No Data");
		ResponseEntity<ExceptionResponse> response = errorHandlerController.businessValidationExceptionHandler(clientException);
		Assert.assertNotNull(response);
	}*/
	
	@Test
	public void handleExecutionExceptionTest() {
		ExecutionException exception = new ExecutionException(404, "Not Found");
		WebRequest request = null;
		ResponseEntity<Object> response =errorHandlerController.handleExecutionException(exception, request);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void handleValidationExceptionTest() {
		ValidationException validationException = new ValidationException("No First Name Found");
		WebRequest request = null;
		ResponseEntity<Object> response =errorHandlerController.handleValidationException(validationException, request);
		Assert.assertNotNull(response);
	}
}

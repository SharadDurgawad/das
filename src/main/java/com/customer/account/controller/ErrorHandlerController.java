package com.customer.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customer.account.exceptions.ApiException;
import com.customer.account.exceptions.ExecutionException;
import com.customer.account.exceptions.ValidationException;
import com.customer.account.model.ExceptionResponse;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<ExceptionResponse> restClientExceptionHandler(RestClientException clientException){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> businessValidationExceptionHandler(RestClientException clientException){
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*@ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Object> handleError405(HttpServletRequest request, Exception e) {
		ExecutionException executionException = new ExecutionException(HttpStatus.METHOD_NOT_ALLOWED.value(),"Method Not allowed");
		ApiException apiException = new ApiException(executionException.getErrorCode(), "Execution Exception",
				executionException.getMessage());
		return new ResponseEntity<Object>(apiException, HttpStatus.resolve(executionException.getErrorCode()));
    }*/
	
	@ExceptionHandler({ ExecutionException.class })
	public ResponseEntity<Object> handleExecutionException(Exception exception, WebRequest request) {
		ExecutionException executionException = (ExecutionException) exception;
		ApiException apiException = new ApiException(executionException.getErrorCode(), "Execution Exception",
				executionException.getMessage());
		return new ResponseEntity<Object>(apiException, HttpStatus.resolve(executionException.getErrorCode()));
	}

	@ExceptionHandler({ ValidationException.class })
	public ResponseEntity<Object> handleValidationException(Exception exception, WebRequest request) {
		ValidationException validationException = (ValidationException) exception;
		ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST.value(), "Validation Exception",
				validationException.getMessage());
		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	}
	
	/*@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponseHandler> executionExceptionHandler(RestClientException clientException){
		return null;
	}*/
}

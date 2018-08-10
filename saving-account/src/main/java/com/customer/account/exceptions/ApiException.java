package com.customer.account.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiException {

	@JsonProperty("status code")
	private int statusCode;

	@JsonProperty("message")
	private String message;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	@JsonProperty("detail message")
	private String detailMessage;

	public ApiException() {
		this.timestamp = LocalDateTime.now();
	}

	public ApiException(int statusCode) {
		this();
		this.statusCode = statusCode;
	}

	public ApiException(int statusCode, String message, String detailMessage) {
		this();
		this.statusCode = statusCode;
		this.message = message;
		this.detailMessage = detailMessage;
	}

	public ApiException(int statusCode, String message) {
		this();
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getmessage() {
		return message;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
}

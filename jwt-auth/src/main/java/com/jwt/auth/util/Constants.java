package com.jwt.auth.util;

public interface Constants {
	
	Long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60l;
    String SIGNING_KEY = "altimetrik";
    String AUTH_TOKEN_PREFIX = "Bearer ";
    String AUTH_HEADER_STRING = "Authorization";
    String REQUEST_STATUS = "request_status";
    String SUCCESS = "sucess";
    String FAILED = "failed";
    String TOKEN = "token";
    String MESSAGE = "message";
}

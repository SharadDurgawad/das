package com.customer.account.utility;

import org.springframework.http.HttpHeaders;

public class HttpUtil {
	
	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		// These can be made configurable to read from properties file.
		// Iterate through all headers defined in properties file and set them.
		headers.add("correlation-ID", "N/A");
		headers.add("Client-ID", "N/A");
		headers.add("Secret-ID", "N/A");
		return headers;
	}
}

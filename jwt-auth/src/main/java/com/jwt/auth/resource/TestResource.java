package com.jwt.auth.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.util.Constants;

@RestController
@RequestMapping("test")
public class TestResource {
	@GetMapping("api")
	public ResponseEntity<?> testThisAPI() {
		Map<String, Object> responseBody = new HashMap<>();
		String msg = "API access approved.";
		responseBody.put(Constants.REQUEST_STATUS, Constants.SUCCESS);
		responseBody.put(Constants.MESSAGE, msg);
		return ResponseEntity.ok(responseBody);
	}

}

package com.jwt.auth.resource;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.config.JwtTokenUtil;
import com.jwt.auth.model.User;
import com.jwt.auth.service.UserService;
import com.jwt.auth.util.Constants;

@RestController
@RequestMapping("token")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("getToken")
    public ResponseEntity<?> register(@RequestBody User data) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		data.getUserName(),
                		data.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = null;
        Map<String, Object> responseBody = new HashMap<>();
		try {
			user = userService.getUserByUserName(data.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		final String token = jwtTokenUtil.generateToken(user);
		
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        responseBody.put(Constants.REQUEST_STATUS, Constants.SUCCESS);
        responseBody.put(Constants.TOKEN, token);
        return ResponseEntity.ok(responseBody);
    }

}

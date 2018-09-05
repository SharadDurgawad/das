package com.customer.account.auth.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.customer.account.configuration.BasicConfiguration;
import com.customer.account.dao.UserRepository;
import com.customer.account.utility.ApplicationConstants;

import io.jsonwebtoken.Jwts;

@Component("JwtAuthorizationFilter")
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private UserDetailsService userDetailService;
	@Autowired
	private AuthenticationManager authManager;
	private BasicConfiguration config;

	private static Logger logger = LogManager.getLogger(JwtAuthorizationFilter.class);

	public JwtAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(ApplicationConstants.HEADER_STRING);
		if (header == null || !header.startsWith(ApplicationConstants.TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(ApplicationConstants.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(ApplicationConstants.SECRET)
					.parseClaimsJws(token.replace(ApplicationConstants.TOKEN_PREFIX, "")).getBody().getSubject();
			if (user != null)
				return authenticate(user, request);
			return null;
		}
		return null;
	}

	private UsernamePasswordAuthenticationToken authenticate(String user, HttpServletRequest request) {
		// Validate against existing users in the system.
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		userDetailService = (UserDetailsService) webApplicationContext.getBean(UserDetailsService.class);
		config = webApplicationContext.getBean(BasicConfiguration.class);
		UserDetails userDetails = null;
		try {
			logger.debug(config.getValidatingUser(), user);
			userDetails = userDetailService.loadUserByUsername(user);
		} catch (UsernameNotFoundException ue) {
			logger.error(config.getUserNotFound(), user);
			return null;
		}
		if (userDetails != null && user.equalsIgnoreCase(userDetails.getUsername()))
			return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
		return null;

	}

	public AuthenticationManager getAuthManager() {
		return authManager;
	}

	public void setAuthManager(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	public UserDetailsService getUserDetailService() {
		return userDetailService;
	}

	public void setUserDetailService(UserDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}
}

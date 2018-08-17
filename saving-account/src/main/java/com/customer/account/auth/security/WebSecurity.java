package com.customer.account.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.customer.account.utility.ApplicationConstants;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	public JwtAuthorizationFilter authorizationTokenFilterBean() throws Exception {
		return new JwtAuthorizationFilter(authenticationManager());
	}
	
	 private UserDetailsService userDetailsService;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, ApplicationConstants.SIGN_UP_URL).permitAll()	//-- To be configured/ignored
	                .anyRequest().authenticated()
	                .and()
	               .addFilter(new JwtAuthenticationFilter(authenticationManager()))
	                .addFilter(new JwtAuthorizationFilter(authenticationManager()));
	    }

	    @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	    }
}

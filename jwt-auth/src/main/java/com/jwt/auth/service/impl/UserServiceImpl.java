package com.jwt.auth.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.auth.model.User;
import com.jwt.auth.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private List<User> users;
	
	public UserServiceImpl() {
		
		users = new ArrayList<User>();
		users.add(new User("altimetrik", "{noop}password"));
	}

	@Override
	public User getUserByUserName(String userName) {
		return users.stream().filter(user -> user.getUserName().equalsIgnoreCase(userName)).findFirst().get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}

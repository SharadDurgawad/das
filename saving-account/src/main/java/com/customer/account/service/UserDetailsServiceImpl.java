package com.customer.account.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customer.account.dao.UserRepository;
import com.customer.account.model.ApplicationUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository applicationUserRepository;

	public UserDetailsServiceImpl(UserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = applicationUserRepository.findByUserName(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUserName(), applicationUser.getPassword(), emptyList());
	}
}

package com.customer.account.dao;

import com.customer.account.model.ApplicationUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUserName(String userName);
}

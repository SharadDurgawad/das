package com.customer.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.account.model.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,String>{
}

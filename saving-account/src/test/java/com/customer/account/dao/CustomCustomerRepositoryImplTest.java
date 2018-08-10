package com.customer.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.customer.account.model.CustomerDetails;

@RunWith(MockitoJUnitRunner.class)
public class CustomCustomerRepositoryImplTest {

	@InjectMocks
	private CustomCustomerRepositoryImpl customCustomerRepositoryImpl;
	
	@Mock
	private EntityManager entityManager;
	
	@Mock
	private CriteriaBuilder criteriaBuilder;
	
	@Mock
	private CriteriaQuery<CustomerDetails> customerQuery;
	
	@Mock
	private Root<CustomerDetails> customerRoot;
	
	@Mock
	private TypedQuery<CustomerDetails> query;
	
	@Mock
	private ParameterExpression<String> activeFlag;
	
	@Mock
	private Path<Object> nicknames;
	
	@Mock
	private Predicate predicate;
	
	@Test
	public void retriveCustomerTest() {
		String customerId = "321313";
		List<CustomerDetails> results = new ArrayList<>();
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccountNumber("553453");
		results.add(customerDetails);
		Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		Mockito.when(criteriaBuilder.createQuery(CustomerDetails.class)).thenReturn(customerQuery);
		Mockito.when(customerQuery.from(CustomerDetails.class)).thenReturn(customerRoot);
		Mockito.when( entityManager.createQuery(customerQuery)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(results);
		List<CustomerDetails> response = customCustomerRepositoryImpl.retriveCustomer(customerId);
		Assert.assertNotNull(response);
	}
	
	@Test
	public void retriveAllCustomerTest() {
		Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		Mockito.when(criteriaBuilder.createQuery(CustomerDetails.class)).thenReturn(customerQuery);
		Mockito.when(customerQuery.from(CustomerDetails.class)).thenReturn(customerRoot);
		Mockito.when(criteriaBuilder.parameter(String.class)).thenReturn(activeFlag);
		Mockito.when(customerRoot.get("isActive")).thenReturn(nicknames);
		Mockito.when(criteriaBuilder.equal(customerRoot.get("isActive"), activeFlag)).thenReturn(predicate);
		Mockito.when(customerQuery.select(customerRoot)).thenReturn(customerQuery);
		Mockito.when( entityManager.createQuery(customerQuery)).thenReturn(query);
		List<CustomerDetails> results = customCustomerRepositoryImpl.retriveAllCustomer();
		Assert.assertNotNull(results);
	}
}

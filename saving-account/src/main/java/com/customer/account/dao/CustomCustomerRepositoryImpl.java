package com.customer.account.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.customer.account.model.CustomerDetails;

@Repository
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CustomerDetails> retriveCustomer(String customerId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails> customerQuery = builder.createQuery(CustomerDetails.class);
		Root<CustomerDetails> customerRoot = customerQuery.from(CustomerDetails.class);
		Predicate p1 = builder.and(builder.equal(customerRoot.get("isActive"), "true"));
		Predicate p2 = builder.and(builder.equal(customerRoot.get("customerId"), customerId));
		List<Predicate> predList = new LinkedList<>();
		predList.add(p1);
		predList.add(p2);
		Predicate[] predArray = new Predicate[predList.size()];
		predList.toArray(predArray);
		customerQuery.where(predArray);
		TypedQuery<CustomerDetails> query = entityManager.createQuery(customerQuery);
		return query.getResultList();
	}

	@Override
	public List<CustomerDetails> retriveAllCustomer() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerDetails> customerQuery = builder.createQuery(CustomerDetails.class);
		Root<CustomerDetails> customerRoot = customerQuery.from(CustomerDetails.class);
		ParameterExpression<String> activeFlag = builder.parameter(String.class);
		customerQuery.select(customerRoot).where(builder.equal(customerRoot.get("isActive"), activeFlag));
		TypedQuery<CustomerDetails> query = entityManager.createQuery(customerQuery);
		query.setParameter(activeFlag, "true");
		return query.getResultList();
	}

}

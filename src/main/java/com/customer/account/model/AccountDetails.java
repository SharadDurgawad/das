package com.customer.account.model;

import java.io.Serializable;

public class AccountDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1320807757100265729L;
	
	private Integer id;
	
	private String accountNumber;
	
	private double balance;
	
	private AccountTypeEnum accountType;
	
	private boolean isActive;
	
	private String branch;
	
	private String customerId;
	
	private String intrestRate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(String intrestRate) {
		this.intrestRate = intrestRate;
	}

	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountType=" + accountType + ", isActive=" + isActive + ", branch=" + branch + ", customerId="
				+ customerId + ", intrestRate=" + intrestRate + "]";
	}	
	
	
}

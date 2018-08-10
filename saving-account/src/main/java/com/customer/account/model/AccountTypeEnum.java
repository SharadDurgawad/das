package com.customer.account.model;

import java.io.Serializable;

public enum AccountTypeEnum implements Serializable {
	SA("saving acoount"), CA("current account");

	private String account;

	private AccountTypeEnum(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}
}

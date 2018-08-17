package com.customer.account.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationUser implements Serializable {

	private static final long serialVersionUID = 1L;

	public ApplicationUser() {

	}

	public ApplicationUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Id
	private long id;
	private String userName;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

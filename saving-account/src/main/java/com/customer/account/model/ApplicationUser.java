package com.customer.account.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

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
	
    @ApiModelProperty(notes = "User name for application login", example = "John", position = 0)
	private String userName;
    
    @ApiModelProperty(notes = "Password for application login", example = "Cena", position = 0)
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

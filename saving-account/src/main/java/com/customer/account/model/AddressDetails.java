package com.customer.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table (name = "address_Details")
public class AddressDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8488082492094551867L;

	@Id 
	@Column(name = "customer_id")
	@JsonProperty("customerId")
	private String customerId;
	
	@Column(name = "city")
	@JsonProperty("city")
	private String city;
	
	@Column(name = "state")
	@JsonProperty("state")
	private String state;
	
	@Column(name = "country")
	@JsonProperty("country")
	private String country;
	
	@Column(name = "sub_division")
	@JsonProperty("subDivision")
	private String subdivision;
	
	@Column(name = "line1")
	@JsonProperty("line1")
	private String line1;
	
	@Column(name = "line2")
	@JsonProperty("line2")
	private String line2;
	
	@Column(name = "line3")
	@JsonProperty("line3")
	private String line3;
	
	@Column(name = "postal_code")
	@JsonProperty("postalCode")
    private int postalCode;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "AddressDetails [customerId=" + customerId + ", city=" + city + ", state="
				+ state + ", country=" + country + ", subdivision=" + subdivision + ", line1=" + line1 + ", line2="
				+ line2 + ", line3=" + line3 + ", postalCode=" + postalCode + "]";
	}
	
		
}

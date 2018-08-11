package com.customer.account.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "customer_details")
public class CustomerDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3922777198804232084L;

	@Id
	@Column(name = "customer_id", nullable = false, unique = true)
	@JsonProperty("customerId")
	private String customerId;

	@Column(name = "unique_id", nullable = false, unique = true)
	private String uniqueId;

	@JsonProperty("accountNumber")
	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@JsonProperty("firstName")
	@Column(name = "cust_first_name", nullable = false)
	private String custFirstName;

	@JsonProperty("middleName")
	@Column(name = "cust_middle_name")
	private String custMiddleName;

	@JsonProperty("lastName")
	@Column(name = "cust_last_name", nullable = false)
	private String custLastName;

	@JsonProperty("dateOfBirth")
	@Column(name = "date_of_birth", nullable = false)
	private String dateOfBirth;

	@JsonProperty("phone")
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@JsonProperty("emailId")
	@Column(name = "email")
	private String emailId;

	@JsonProperty("gender")
	@Column(name = "gender")
	private String gender;

	@Column(name = "is_active")
	private String isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(referencedColumnName = "customer_id") })
	private AddressDetails addressDetails;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustMiddleName() {
		return custMiddleName;
	}

	public void setCustMiddleName(String custMiddleName) {
		this.custMiddleName = custMiddleName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", uniqueId=" + uniqueId + ", accountNumber="
				+ accountNumber + ", custFirstName=" + custFirstName + ", custMiddleName=" + custMiddleName
				+ ", custLastName=" + custLastName + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ", gender=" + gender + ", isActive=" + isActive + ", addressDetails="
				+ addressDetails + "]";
	}
	

}

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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "customer_details")
@ApiModel(description = "Class representing a customer details tracked by the application.")
public class CustomerDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3922777198804232084L;

	@Id
	@Column(name = "customer_id", nullable = false, unique = true)
	@JsonProperty("customerId")
    @ApiModelProperty(notes = "Unique identifier of the customer. No two persons can have the same id.", example = "1", position = 0)
	private String customerId;

    @ApiModelProperty(notes = "Unique identifier of the customer. No two persons can have the same id.", example = "1", position = 0)
	@Column(name = "unique_id", nullable = false, unique = true)
    @JsonProperty("uniqueId")
	private String uniqueId;

    @ApiModelProperty(notes = "Unique identifier of the customer. No two persons can have the same id.", example = "1", position = 0)
	@JsonProperty("accountNumber")
	@Column(name = "account_number", nullable = false)
	private String accountNumber;
    
    @ApiModelProperty(notes = "First Name of the customer.", example = "John", required = true)
	@JsonProperty("firstName")
	@Column(name = "cust_first_name", nullable = false)
	private String custFirstName;

    @ApiModelProperty(notes = "Middle Name of the customer.", example = "Smith", required = false)
	@JsonProperty("middleName")
	@Column(name = "cust_middle_name")
	private String custMiddleName;

    @ApiModelProperty(notes = "Middle Name of the customer.", example = "Doe", required = true)
	@JsonProperty("lastName")
	@Column(name = "cust_last_name", nullable = false)
	private String custLastName;

    @ApiModelProperty(notes = "Date of Birth for the customer.", example = "18/12/1994", required = true)
	@JsonProperty("dateOfBirth")
	@Column(name = "date_of_birth", nullable = false)
	private String dateOfBirth;

    @ApiModelProperty(notes = "Phone number of the customer.", example = "9876543210", required = true)
	@JsonProperty("phone")
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

    @ApiModelProperty(notes = "Email Id for the customer.", example = "someone@gmail.com", required = true)
	@JsonProperty("emailId")
	@Column(name = "email")
	private String emailId;

    @ApiModelProperty(notes = "Gender of the customer", example = "Male/Femal", required = true)
	@JsonProperty("gender")
	@Column(name = "gender")
	private String gender;

    @ApiModelProperty(notes = "Active flag for the customer", example = "true/false", required = true)
	@Column(name = "is_active")
	private String isActive;

    @ApiModelProperty(notes = "Unique identifier of the person. No two persons can have the same id.", example = "1", required = true)
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

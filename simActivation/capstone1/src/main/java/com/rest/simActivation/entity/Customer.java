package com.rest.simActivation.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Customer {
	@Id
	@Digits(integer=16,fraction=0,message="Id should be of 16 digits")
	private long uniqueIdNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	@NotEmpty
	@Email(regexp="^[a-zA-Z0-9+-_.]+@[a-zA-Z]+.[a-zA-Z]{2,3}",message="Invalid Email")
	private String emailAddress;
	@NotEmpty
	@Size(max=15,message="FirstName/LastName should be maximum of 15 characters")
	private String firstName;
	@Size(max=15,message="FirstName/LastName should be maximum of 15 characters")
	@NotEmpty
	private String lastName;
	private String idType;
//	@Column
//	private int customer_Address_addressId;
	@Column(name="sim_id")
	private int simId;
	private String state;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Add_id",unique=true)
	private CustomerAddress customerAddress;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="unique_id",unique=true)
//	private CustomerIdentity customerIdentity;
//	
	
	public long getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public Customer(long uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName, String lastName,
		String idType, int simId, String state) {
	super();
	this.uniqueIdNumber = uniqueIdNumber;
	this.dateOfBirth = dateOfBirth;
	this.emailAddress = emailAddress;
	this.firstName = firstName;
	this.lastName = lastName;
	this.idType = idType;
	this.simId = simId;
	this.state = state;
	//this.customerAddress = customerAddress;
}
	public void setUniqueIdNumber(long uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
//	ŚŚŚ
	public int getSimId() {
		return simId;
	}
	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

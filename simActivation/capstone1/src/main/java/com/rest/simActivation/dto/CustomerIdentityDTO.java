package com.rest.simActivation.dto;

import java.time.LocalDate;

import com.rest.simActivation.entity.CustomerIdentity;

public class CustomerIdentityDTO {
	private long uniqueIdNumber;
	private LocalDate dateOfbirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	public CustomerIdentityDTO(long uniqueNumber, LocalDate dateOfBirth, String firstName, String lastName,
			String emailAddress, String state) {
		super();
		this.uniqueIdNumber = uniqueNumber;
		this.dateOfbirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.state = state;
	}
	public long getUniqueNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueNumber(long uniqueNumber) {
		this.uniqueIdNumber = uniqueNumber;
	}
	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CustomerIdentityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static CustomerIdentity prepareCustomerIdentityEntity(CustomerIdentityDTO cus) {
		// TODO Auto-generated method stub
		CustomerIdentity cusEntity=new CustomerIdentity();
		cusEntity.setDateOfbirth(cus.getDateOfbirth());
		cusEntity.setEmailAddress(cus.getEmailAddress());
		cusEntity.setFirstName(cus.getFirstName());
		cusEntity.setState(cus.getState());
		cusEntity.setUniqueNumber(cus.getUniqueNumber());
		cusEntity.setLastName(cus.getLastName());
		return cusEntity;
	}
	
}

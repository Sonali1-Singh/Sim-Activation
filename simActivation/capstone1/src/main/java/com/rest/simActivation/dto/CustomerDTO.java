package com.rest.simActivation.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.rest.simActivation.entity.Customer;

public class CustomerDTO {
	private long uniqueIdNumber;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate dateOfBirth;
	@Email(regexp="^(.+)@[a-zA-Z]+.[a-zA-Z]{2,3}")
	private String emailAddress;
	@Size(max=15, message="Firstname should be maximum of 15 characters")
	private String firstName;
	@Size(max=15, message="Firstname should be maximum of 15 characters")
	private String lastName;
	private String idType;
	//private int customer_Address_addressId;
	private int simId;
	private String state;
	public CustomerDTO(long uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName, String lastName,
			String idType,int simId, String state) {
		super();
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		//this.customer_Address_addressId = customer_Address_addressId;
		this.simId = simId;
		this.state = state;
	}
	public long getUniqueIdNumber() {
		return uniqueIdNumber;
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
//	public int getCustomer_Address_addressId() {
//		return customer_Address_addressId;
//	}
//	public void setCustomer_Address_addressId(int customer_Address_addressId) {
//		this.customer_Address_addressId = customer_Address_addressId;
//	}
	public int getSimId() {
		return simId;
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
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Customer prepareCustomerEntity(CustomerDTO cus) {
		// TODO Auto-generated method stub
		Customer cusEntity=new Customer();
		cusEntity.setEmailAddress(cus.getEmailAddress());
		cusEntity.setFirstName(cus.getFirstName());
		cusEntity.setDateOfBirth(cus.getDateOfBirth());
		cusEntity.setLastName(cus.getLastName());
		cusEntity.setSimId(cus.getSimId());
		//cusEntity.setCustomer_Address_addressId(cus.getCustomer_Address_addressId());
		cusEntity.setIdType(cus.getIdType());
		cusEntity.setState(cus.getState());
		cusEntity.setUniqueIdNumber(cus.getUniqueIdNumber());
		return cusEntity;
	}
	

}

package com.rest.simActivation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity

public class CustomerAddress {
	@Id
	@Column(name="Add_id")
	private int addressId;
	@Size(max=25, message="Address should be maximum of 25 characters")
	private String address;
	@Pattern(regexp="^[a-zA-Z0-9 ]+$",message="City/State should not contain any special character except space")
	private String city;
	@Digits(integer=6,fraction=0,message="Pin should be 6 digit number")
	private int pincode;
	@Pattern(regexp="^[a-zA-Z0-9 ]+$",message="City/State should not contain any special character except space")
	private String state;
	public CustomerAddress(int addressId, String address, String city, int pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

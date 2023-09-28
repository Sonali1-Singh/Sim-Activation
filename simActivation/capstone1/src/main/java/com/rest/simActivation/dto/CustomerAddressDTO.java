package com.rest.simActivation.dto;

import com.rest.simActivation.entity.CustomerAddress;

public class CustomerAddressDTO {
	
	private int addressId;
	private String address;
	private String city;
	private int pincode;
	private String state;
	public CustomerAddressDTO(int addressId, String address, String city, int pincode, String state) {
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
	public CustomerAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static CustomerAddress prepareCustomerEntity(CustomerAddressDTO cus) {
		// TODO Auto-generated method stub
		CustomerAddress cusEntity=new CustomerAddress();
		cusEntity.setAddress(cus.getAddress());
		cusEntity.setAddressId(cus.getAddressId());
		cusEntity.setCity(cus.getCity());
		cusEntity.setPincode(cus.getPincode());
		cusEntity.setState(cus.getState());
		return cusEntity;
	}

}

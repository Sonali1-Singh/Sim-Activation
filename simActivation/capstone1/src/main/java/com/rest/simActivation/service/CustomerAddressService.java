package com.rest.simActivation.service;

import javax.validation.Valid;

import com.rest.simActivation.dto.CustomerAddressDTO;

public interface CustomerAddressService {
	public void insertCustomerAddress(CustomerAddressDTO cus);
	public void updateAddress(@Valid CustomerAddressDTO customerAddDTO);

}

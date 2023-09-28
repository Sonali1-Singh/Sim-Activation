package com.rest.simActivation.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.simActivation.dto.CustomerAddressDTO;
import com.rest.simActivation.entity.CustomerAddress;
import com.rest.simActivation.repository.CustomerAddressRepo;


@Service
public class CustomerAddressServiceImpl implements CustomerAddressService{
	@Autowired
	private CustomerAddressRepo repository;

	@Override
	public void insertCustomerAddress(CustomerAddressDTO cus) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(CustomerAddressDTO.prepareCustomerEntity(cus));
	}
	@Override
	public void updateAddress(@Valid CustomerAddressDTO customerAddDTO) {
		// TODO Auto-generated method stub
		CustomerAddress customerEntity=repository.findByAddressId(customerAddDTO.getAddressId());
		if(customerEntity!=null) {
			customerEntity.setAddress(customerAddDTO.getAddress());
			customerEntity.setCity(customerAddDTO.getCity());
			customerEntity.setPincode(customerAddDTO.getPincode());
			customerEntity.setState(customerAddDTO.getState());
			repository.save(customerEntity);
		}
		else {
			repository.saveAndFlush(CustomerAddressDTO.prepareCustomerEntity(customerAddDTO));
		}
	}
	

}

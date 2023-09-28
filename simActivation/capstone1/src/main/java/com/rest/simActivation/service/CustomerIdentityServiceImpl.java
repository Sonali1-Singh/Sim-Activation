package com.rest.simActivation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.simActivation.dto.CustomerIdentityDTO;
import com.rest.simActivation.repository.CustomerIdentityRepo;
@Service
public class CustomerIdentityServiceImpl implements CustomerIdentityService {
	@Autowired
	private CustomerIdentityRepo repository;

	@Override
	public void insertCustomerIdentity(CustomerIdentityDTO cus) {
		
		// TODO Auto-generated method stub
		repository.saveAndFlush(CustomerIdentityDTO.prepareCustomerIdentityEntity(cus));
		
	}
	

}

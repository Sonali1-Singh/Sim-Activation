package com.rest.simActivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.simActivation.entity.CustomerAddress;

public interface CustomerAddressRepo extends JpaRepository<CustomerAddress,Integer> {

	CustomerAddress findByAddressId(int addressId);

}

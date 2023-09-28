package com.rest.simActivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.simActivation.entity.CustomerIdentity;

public interface CustomerIdentityRepo extends JpaRepository<CustomerIdentity,Long> {

}

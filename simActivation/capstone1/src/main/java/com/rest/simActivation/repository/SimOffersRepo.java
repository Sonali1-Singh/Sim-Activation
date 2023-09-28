package com.rest.simActivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.simActivation.entity.SimOffers;

public interface SimOffersRepo extends JpaRepository<SimOffers,Integer>{
	
}

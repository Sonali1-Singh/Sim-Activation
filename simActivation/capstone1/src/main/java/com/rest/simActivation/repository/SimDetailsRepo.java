package com.rest.simActivation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.simActivation.entity.SimDetails;

public interface SimDetailsRepo extends JpaRepository<SimDetails,Integer> {

//	long findBysimNumber(long simNumber);
//	long findByserviceNumber(long serviceNumber);
	SimDetails findByServiceNumberAndSimNumber(Long serviceNumber, Long simNumber);

	SimDetails findBySimId(int sim_id);

}

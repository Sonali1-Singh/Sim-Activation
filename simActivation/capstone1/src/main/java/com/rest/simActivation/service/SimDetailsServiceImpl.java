package com.rest.simActivation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.simActivation.dto.SimDetailsDTO;
//import com.rest.simActivation.dto.SimOffersDTO;
import com.rest.simActivation.entity.SimDetails;
import com.rest.simActivation.entity.SimOffers;
import com.rest.simActivation.exception.SimException;
import com.rest.simActivation.repository.SimDetailsRepo;

@Service
public  class SimDetailsServiceImpl implements SimDetailsService {
	@Autowired
    private SimDetailsRepo repository;
	@Override
	public void insertSimDetails(SimDetailsDTO sim) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(SimDetailsDTO.prepareSimDetailEntity(sim));
	}
//	
	public List<SimOffers> getSimOffers(Long simNumber, Long serviceNumber) throws SimException{
	SimDetails sim = repository.findByServiceNumberAndSimNumber(serviceNumber,simNumber);
	
		if(sim!=null) {
			if(sim.getSimStatus().equalsIgnoreCase("inactive")) {
				
				return sim.getSimOffers();
				
			}
			else {
				throw new SimException("SimAlreadyActive");
				
			}
		}
		else {
			throw new SimException("Invalid details");
		
			
		}
}
}

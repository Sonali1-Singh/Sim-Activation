package com.rest.simActivation.service;

import java.util.List;

import com.rest.simActivation.dto.SimDetailsDTO;
//import com.rest.simActivation.entity.Customer;
import com.rest.simActivation.entity.SimOffers;
import com.rest.simActivation.exception.SimException;

public interface SimDetailsService {
	public void insertSimDetails(SimDetailsDTO sim);

	//public long validateDetails(long simNumber, long serviceNumber);

	//public boolean getSimStatus(long sim_id);

	//public SimOfferDTO getSimOffer(int sim_id);

	public List<SimOffers> getSimOffers(Long simNumber, Long serviceNumber) throws SimException;

}

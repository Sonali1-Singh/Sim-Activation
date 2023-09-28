package com.rest.simActivation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.simActivation.dto.SimOffersDTO;
import com.rest.simActivation.repository.SimOffersRepo;
@Service
public class SimOffersServiceImpl implements SimOffersService {
    @Autowired
    private SimOffersRepo repository;
	@Override
	public void insertSimOffers(SimOffersDTO sim) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(SimOffersDTO.prepareSimOfferEntity(sim));
	}
}

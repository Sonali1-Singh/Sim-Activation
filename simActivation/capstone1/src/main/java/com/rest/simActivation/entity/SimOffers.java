package com.rest.simActivation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.rest.simActivation.dto.SimOffersDTO;

@Entity
public class SimOffers {
	@Id
	private int OfferId;
	private int callQty;
	private int cost;
	private int dataQty;
	private int duration;
	private String offerName;
	@Column
	private int simId;
	public SimOffers(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, int simId) {
		super();
		OfferId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simId = simId;
	}
	public int getOfferId() {
		return OfferId;
	}
	public void setOfferId(int offerId) {
		OfferId = offerId;
	}
	public int getCallQty() {
		return callQty;
	}
	public void setCallQty(int callQty) {
		this.callQty = callQty;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDataQty() {
		return dataQty;
	}
	public void setDataQty(int dataQty) {
		this.dataQty = dataQty;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public int getSimId() {
		return simId;
	}
	public void setSimId(int simId) {
		this.simId = simId;
	}
	public SimOffers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static SimOffersDTO prepareSimDTO(SimOffers offer) {
		// TODO Auto-generated method stub
		SimOffersDTO offerDto=new SimOffersDTO(offer.getOfferId(),offer.getCallQty(),offer.getCost(),offer.getDataQty(),offer.getDuration(), 
				offer.getOfferName(),offer.getSimId());
		return offerDto;
	}
	
	
}

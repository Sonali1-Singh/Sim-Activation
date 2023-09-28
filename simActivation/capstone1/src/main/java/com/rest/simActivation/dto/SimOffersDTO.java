package com.rest.simActivation.dto;

import com.rest.simActivation.entity.SimOffers;

public class SimOffersDTO {
	
	private int OfferId;
	private int callQty;
	private int cost;
	private int dataQty;
	private int duration;
	private String offerName;
	private int simId;
	public SimOffersDTO(int offerId, int callQty, int cost, int dataQty, int duration, String offerName, int simId) {
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
	public SimOffersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static SimOffers prepareSimOfferEntity(SimOffersDTO sim) {
		// TODO Auto-generated method stub
		SimOffers simEntity=new SimOffers();
		simEntity.setCallQty(sim.getCallQty());
		simEntity.setCost(sim.getCost());
		simEntity.setDataQty(sim.getDataQty());
		simEntity.setDuration(sim.getDuration());
		simEntity.setOfferId(sim.getOfferId());
		simEntity.setOfferName(sim.getOfferName());
		simEntity.setSimId(sim.getSimId());
		return simEntity;
	}
	
}

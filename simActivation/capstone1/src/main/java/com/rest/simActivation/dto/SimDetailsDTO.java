package com.rest.simActivation.dto;

import com.rest.simActivation.entity.SimDetails;
//import com.rest.simActivation.entity.SimOffers;

public class SimDetailsDTO {
	//private int simId;
	private Long serviceNumber;
	private Long simNumber;
	private String simStatus;
	//private SimOffers simoffer;
	public SimDetailsDTO(long serviceNumber, long simNumber, String simStatus) {
		super();
	//	this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
//	public int getSimId() {
//		return simId;
//	}
//	public void setSimId(int simId) {
//		this.simId = simId;
//	}
	public long getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public long getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(long simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	public SimDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static SimDetails prepareSimDetailEntity(SimDetailsDTO sim) {
		// TODO Auto-generated method stub
		SimDetails simEntity=new SimDetails();
		simEntity.setServiceNumber(sim.getServiceNumber());
		//simEntity.setSimId(sim.getSimId());
		simEntity.setSimNumber(sim.getSimNumber());
		simEntity.setSimStatus(sim.getSimStatus());
		return simEntity;
	}
	
}

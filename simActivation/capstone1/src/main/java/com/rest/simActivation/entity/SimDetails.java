package com.rest.simActivation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import javax.persistence.Table;
//@NamedQuery(name="SimDetails.findbySimNumberAndServiceNumber",query="Select * from SimDetails where simNumber=?1")
//@NamedQuery(name="SimDetails.findbyServiceNumber",query="Select sim_id from SimDetails where serviceNumber=?2")
@Entity
public class SimDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int simId;
	@Digits(integer=10,fraction=0, message="Invalid details")
	private Long serviceNumber;
	@Digits(integer=13,fraction=0, message="Invalid details")
	private Long simNumber;
	private String simStatus;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="simId")
	private List<SimOffers> simOffers=new ArrayList<>();
	
	public List<SimOffers> getSimOffers() {
		return simOffers;
	}
//	public void setSimOffers(SimOffers simOffers) {
//		this.simOffers = simOffers;
//	}
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="sim_id",unique=true)
//	private Customer customer;
	
	//-----------------------------------------------------------------------
	public SimDetails(long serviceNumber, long simNumber, String simStatus) {
		super();
		//this.simId = simId;
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
	public SimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

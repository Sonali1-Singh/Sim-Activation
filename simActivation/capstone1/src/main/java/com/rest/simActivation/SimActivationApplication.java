package com.rest.simActivation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.rest.simActivation.dto.CustomerAddressDTO;
import com.rest.simActivation.dto.CustomerDTO;
import com.rest.simActivation.dto.CustomerIdentityDTO;
import com.rest.simActivation.dto.SimDetailsDTO;
import com.rest.simActivation.dto.SimOffersDTO;
import com.rest.simActivation.service.CustomerAddressService;
import com.rest.simActivation.service.CustomerIdentityService;
import com.rest.simActivation.service.CustomerService;
import com.rest.simActivation.service.SimDetailsService;
import com.rest.simActivation.service.SimOffersService;

@SpringBootApplication
@Component("com")
public class SimActivationApplication implements CommandLineRunner {
	@Autowired
	SimDetailsService simService;
	@Autowired
	SimOffersService offerService;
	@Autowired
	CustomerService service;
	@Autowired
	CustomerAddressService cusAddservice;
	@Autowired
	CustomerIdentityService idenService;
	public static void main(String[] args) {
		SpringApplication.run(SimActivationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		SimDetailsDTO sim1=new SimDetailsDTO(1234567891L,1234567891234L,"active");
		SimDetailsDTO sim2=new SimDetailsDTO(1234567892L,1234567891235L,"inactive");
		simService.insertSimDetails(sim1);
		simService.insertSimDetails(sim2);
		
		SimOffersDTO simOffer1=new SimOffersDTO(1,100,100,120,10,"Free calls and data",1);
		SimOffersDTO simOffer2=new SimOffersDTO(2,150,50,100,15,"Free calls",2);
		SimOffersDTO simOffer3=new SimOffersDTO(3,150,50,100,15,"Free data",2);
		offerService.insertSimOffers(simOffer1);
		offerService.insertSimOffers(simOffer2);
		offerService.insertSimOffers(simOffer3);
		
		
		CustomerAddressDTO cusAdd1=new CustomerAddressDTO(1,"Jayanagar","Banglore",560041,"Karnatka");
		CustomerAddressDTO cusAdd2=new CustomerAddressDTO(2,"Vijayanagar","Mysore",567017,"Karna");
		cusAddservice.insertCustomerAddress(cusAdd1);
		cusAddservice.insertCustomerAddress(cusAdd2);
		
		CustomerDTO cus1=new CustomerDTO(1234567891234567L,LocalDate.of(1990,12,12),"smith@abc.com","Smith","John","Aadhar",1,"Karnatka");
		CustomerDTO cus2=new CustomerDTO(1234567891234568L,LocalDate.of(1998,12,12),"bob@abc.com","Bob","John","Sam",2,"Karnatka");
		service.insertCustomer(cus1);
		service.insertCustomer(cus2);
		
		CustomerIdentityDTO cusIden1=new CustomerIdentityDTO(1234567891234567L,LocalDate.of(1990,12,12),"Smith","John","smith@abc.com","Karnatka");
		CustomerIdentityDTO cusIden2=new CustomerIdentityDTO(1234567891234568L,LocalDate.of(1998,12,12),"Bob","Sam","bob@abc.com","Karnatka");
		idenService.insertCustomerIdentity(cusIden1);
		idenService.insertCustomerIdentity(cusIden2);
	}

}

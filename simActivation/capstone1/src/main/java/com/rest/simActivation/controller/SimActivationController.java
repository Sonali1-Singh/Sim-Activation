package com.rest.simActivation.controller;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.simActivation.dto.CustomerAddressDTO;
import com.rest.simActivation.dto.CustomerDTO;
//import com.rest.simActivation.dto.SimDetailsDTO;
import com.rest.simActivation.dto.SimOffersDTO;
//import com.rest.simActivation.entity.Customer;
//import com.rest.simActivation.entity.SimDetails;
import com.rest.simActivation.entity.SimOffers;
import com.rest.simActivation.exception.SimException;
import com.rest.simActivation.service.CustomerAddressService;
import com.rest.simActivation.service.CustomerService;
//import com.rest.simActivation.service.CustomerService;
import com.rest.simActivation.service.SimDetailsService;

@RestController
@RequestMapping("/sim")
public class SimActivationController {
	@Autowired
	SimDetailsService service;
	@PostMapping(value="/simDetails")
	public ResponseEntity<List<SimOffersDTO>> validateDetails(@Valid @NotEmpty(message="SimNo required") @RequestParam("simNo") String simNumber,
			@Valid @RequestParam("serviceNo") String serviceNumber) throws SimException{
		//System.out.println(simNumber+serviceNumber);
		List<SimOffers> offers=service.getSimOffers(Long.parseLong(simNumber),Long.parseLong(serviceNumber));
		List<SimOffersDTO> offerDto= new ArrayList<>();
		for (SimOffers simOffers : offers) {
			offerDto.add(SimOffers.prepareSimDTO(simOffers));
		}
 		return ResponseEntity.status(HttpStatus.ACCEPTED).body(offerDto);
	}
	
	@Autowired
	CustomerService cusService;
	@PostMapping(value="/basicDetails")
	public ResponseEntity<String> verifyDetails(@Valid @NotEmpty(message="email/dob is mandatory") @RequestBody CustomerDTO cus) 
			throws SimException{
		cusService.verifyBasicDetails(cus.getEmailAddress(),cus.getDateOfBirth());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success");
	}
	
	@PostMapping(value="/personalDetails")
	public ResponseEntity<String> verifyPersonalDetails(@Valid @RequestParam("first_name") String first,
			@Valid @RequestParam("last_name") String last, @Valid @RequestParam("confirm_email") String email){
		cusService.verifyPersonalDetails(first,last,email);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success");
	}
	@Autowired
	CustomerAddressService cusAddService;
	@PutMapping(value="/updateAddress")
	public ResponseEntity<String> updateCustomerAddress(@Valid @RequestBody CustomerAddressDTO customerAddDTO){
		cusAddService.updateAddress(customerAddDTO);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Address updated successfully");
	}
	@PostMapping(value="/IdProofValidation")
	public ResponseEntity<String> verifyAllDetails(@Valid @RequestBody CustomerDTO customer){
		cusService.verifyIdPrrofDetails(customer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sim status is successfully activated");
	}
} 

//POST   http://localhost:8080/infy/sim/simDetails?simNo=&serviceNo=1234567891
//POST http://localhost:8080/infy/sim/basicDetails

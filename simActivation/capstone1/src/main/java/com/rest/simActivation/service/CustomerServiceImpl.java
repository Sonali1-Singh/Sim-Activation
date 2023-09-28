package com.rest.simActivation.service;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.simActivation.dto.CustomerDTO;
import com.rest.simActivation.entity.Customer;
import com.rest.simActivation.entity.SimDetails;
import com.rest.simActivation.exception.CustomerNotFoundException;
import com.rest.simActivation.exception.SimException;
import com.rest.simActivation.repository.CustomerRepo;
import com.rest.simActivation.repository.SimDetailsRepo;

@Service
public class CustomerServiceImpl  implements CustomerService {
		@Autowired
	    private CustomerRepo repository;
		@Override
		public void insertCustomer(CustomerDTO cus) {
			// TODO Auto-generated method stub
			repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(cus));			
		}
		@Override
		public void verifyBasicDetails(@Valid @NotEmpty String email, @Valid @NotEmpty LocalDate dob)
				throws SimException {
			// TODO Auto-generated method stub
			Customer cus=repository.findByDateOfBirthAndEmailAddress(dob,email);
			if(cus==null) {
				throw new SimException("No request placed for you");
			}
			return;
			
		}
		@Override
		public void verifyPersonalDetails(@Valid String first, @Valid String last, @Valid String confirmEmail) throws CustomerNotFoundException,SimException{
			// TODO Auto-generated method stub
			Customer cus=repository.findByFirstNameAndLastName(first,last);
			if(cus==null) {
				throw new CustomerNotFoundException();
			}
	
			if(confirmEmail.equals(cus.getEmailAddress())) {
				return;
			}
			else {
				throw new SimException("Inval email details");
			}
		}
		
		@Autowired 
		SimDetailsRepo simRepository;
		public void verifyIdPrrofDetails(@Valid CustomerDTO customer) throws SimException,CustomerNotFoundException {
			Customer cus=repository.findByUniqueIdNumber(customer.getUniqueIdNumber());
			if(cus!=null) {
				if(cus.getFirstName().equals(customer.getFirstName()) && cus.getLastName().equals(customer.getLastName())) {
					if(customer.getDateOfBirth().isEqual(cus.getDateOfBirth())) {
						int sim_id=cus.getSimId();
						SimDetails s=simRepository.findBySimId(sim_id);
						s.setSimStatus("active");	
						simRepository.save(s);
						return;
					}
					else {
						throw new SimException("Incorrect date of birth details");
					}
				}
				else
					throw new SimException("Invalid Details");
			}
			else
				throw new CustomerNotFoundException();
		}
}
//Customer cus1=repository.findByEmailAddress(confirmEmail);
//if(cus1==null) {
//	throw new InvalidEmailException();
//}

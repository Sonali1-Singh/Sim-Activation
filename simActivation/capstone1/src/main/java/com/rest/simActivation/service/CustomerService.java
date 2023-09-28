package com.rest.simActivation.service;


import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.rest.simActivation.dto.CustomerDTO;
import com.rest.simActivation.entity.Customer;
import com.rest.simActivation.exception.SimException;

public interface CustomerService {
	public void insertCustomer(CustomerDTO cus);

	public void verifyBasicDetails(@Valid @NotEmpty String email, @Valid @NotEmpty LocalDate localDate) throws SimException;

	public void verifyPersonalDetails(@Valid String first, @Valid String last, @Valid String email);
	public void verifyIdPrrofDetails(@Valid CustomerDTO customer);

	//public Customer findBySimId(int sim_id);

}

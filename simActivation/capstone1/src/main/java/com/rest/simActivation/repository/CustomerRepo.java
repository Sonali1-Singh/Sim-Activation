package com.rest.simActivation.repository;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.simActivation.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

	Customer findByDateOfBirthAndEmailAddress(@Valid @NotEmpty LocalDate dob,@Valid @NotEmpty String email);

	Customer findByFirstNameAndLastName(@Valid String first, @Valid String last);

	Customer findByUniqueIdNumber(long uniqueIdNumber);

//	Customer findByEmailAddress(@Valid String confirmEmail);


}

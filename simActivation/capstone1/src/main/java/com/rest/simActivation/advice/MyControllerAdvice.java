package com.rest.simActivation.advice;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rest.simActivation.exception.CustomerNotFoundException;
import com.rest.simActivation.exception.SimException;

@RestControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExcep(MethodArgumentNotValidException ex){
		String msg=ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException ex) 
	{
		String msg=ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
			        		                          .collect(Collectors.joining(", "));
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SimException.class)
	public ResponseEntity<String> handleAlreadyActivatedExcep(SimException sim){
		return new ResponseEntity<String>(sim.getMessage(),HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundExcep(CustomerNotFoundException s){
		return new ResponseEntity<String>("No customer found for the provided details",HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<String> handleNumberExcep(NumberFormatException e){
		return new ResponseEntity<String>("Please provide required details",HttpStatus.BAD_REQUEST);	
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleExcep(Exception e){
//		return new ResponseEntity<String>("Please provide correct details",HttpStatus.OK);	
//	}

}

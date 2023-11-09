package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;
import com.masai.services.CustomerService;
import jakarta.validation.Valid;

@RestController
public class CustomerControllerHandler {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer>savedCustomer(@Valid @org.springframework.web.bind.annotation.RequestBody Customer cus) throws CustomerException{
		
		Customer savedCus= customerService.registerCustomer(cus);
		
		return new ResponseEntity<Customer>(savedCus,HttpStatus.CREATED);
		
	}
	
	
	
	
	

}

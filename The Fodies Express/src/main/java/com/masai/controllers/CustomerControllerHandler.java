package com.masai.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.CustomerException;
import com.masai.models.Customer;
import com.masai.services.CustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerControllerHandler {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/registerCustoemrs")
	public ResponseEntity<String>registerCustomer(@Valid @RequestBody Customer newCoustomer ) throws CustomerException{
		
		String savedCoustomer= customerService.registerCustomer(newCoustomer);
		
		return new ResponseEntity<String>(savedCoustomer,HttpStatus.CREATED);
		
	}
	
//************************************************************************************************************
	
	@PutMapping("/updateCustomer/{userName}")
	public ResponseEntity<Customer> updateProfile(@PathVariable("userName") String userName,  @RequestBody Customer updatedCustomer) throws CustomerException{
		
		Customer updatedCustomerEntity= customerService.updateProfileDetails(userName, updatedCustomer);
		
		return new ResponseEntity<Customer>(updatedCustomerEntity,HttpStatus.OK);
		
	}
	

//************************************************************************************************************
	
	@DeleteMapping("/deleteCustomer/{userName}")
	public ResponseEntity<String> deleteAccount(@PathVariable("userName") String userName) throws CustomerException{
            
		 String deleteStatus= customerService.deleteAccount(userName);
		 
		return new ResponseEntity<String>(deleteStatus,HttpStatus.MOVED_PERMANENTLY);			
	
	}
	
	
//**************************************************************************************************************
	@GetMapping("/getAccountDetails/{userName}")
	public ResponseEntity<Customer> getAccountDetails(@PathVariable("userName") String userName) throws CustomerException{
		
		Customer accountDetails= customerService.getAccountDetails(userName);
		
		return new ResponseEntity<Customer>(accountDetails,HttpStatus.OK);
		
	}


}

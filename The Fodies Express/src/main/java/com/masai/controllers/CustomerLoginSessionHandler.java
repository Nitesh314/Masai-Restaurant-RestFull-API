package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginSessionException;
import com.masai.models.LoginDTO;
import com.masai.services.LoginSessionService;



@RestController
@RequestMapping("/loginCustomers")
public class CustomerLoginSessionHandler {
	
	@Autowired
	private LoginSessionService loginSessionService;
	
	@PostMapping("/login")
	public ResponseEntity<String>loginCustomer(@RequestBody LoginDTO lDto) throws LoginSessionException{
		
		 String loginCoustomer= loginSessionService.customerLogin(lDto);
		 
		 return new ResponseEntity<String>(loginCoustomer,HttpStatus.OK);
	}
	
//**********************************************************************************************************************************
	
	@PatchMapping("/logOut/{userName}")
	public ResponseEntity<String>logOutCustomer(@PathVariable("userName") String userName) throws LoginSessionException{
		
		String logOutCustomer= loginSessionService.customerLogOut(userName);
		
		return new ResponseEntity<String>(logOutCustomer,HttpStatus.OK);
		
	}

}

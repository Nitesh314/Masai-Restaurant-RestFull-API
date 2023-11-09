package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.models.LoginDTO;
import com.masai.services.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginControllerHandler {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String>loginInToAccount(@RequestBody LoginDTO lDto) throws LoginException{
		
		String login= loginService.loginInToAccount(lDto);
		
		return new ResponseEntity<String>(login,HttpStatus.OK);
		
	}

}

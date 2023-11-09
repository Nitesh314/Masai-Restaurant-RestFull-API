package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.models.Customer;
import com.masai.models.Login;
import com.masai.models.LoginDTO;
import com.masai.repositorys.CustomerRepository;
import com.masai.repositorys.LoginRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public String loginInToAccount(LoginDTO lDto) throws LoginException {
		
		//first we check the customer is existing or not using mobile number;
		
		Customer existingCustomer= customerRepo.findByMobileNumber(lDto.getMobileNumber());
		
		if(existingCustomer==null) {
			throw new LoginException("Enter the valid mobile number... ");
		}else {
			
			Optional<Login> existingCutomerId=  loginRepo.findById(existingCustomer.getCustomerId());
			
			if(existingCutomerId.isPresent()) {
				throw new LoginException("user already exist with id :"+existingCustomer.getCustomerId());
			}else {
				
				if(existingCustomer.getPassword().equals(lDto.getPassword())) {
					
					//create 6 digit random uuId;
					String uuId=RandomString.make(6);
					
					Login curentUserLogin=new Login(existingCustomer.getCustomerId(),uuId,existingCustomer.getPassword(),LocalDateTime.now());
					
					loginRepo.save(curentUserLogin);
					
					return curentUserLogin.toString();
					
				}else {
					throw new LoginException("Enter the Valid Pssword");
				}
				
			}
			
		}
		
	}

	@Override
	public String logOutFromAccount(String uuId) throws LoginException {
		
		Login exictngUser = loginRepo.findByUuId(uuId);
		
		if(exictngUser==null) {
			throw new LoginException("User not found...");
		}else {
			
			loginRepo.delete(exictngUser);
			
			return "Successfully loggOut...!";
			
		}
		
	}

}

package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.LoginSessionException;
import com.masai.models.Customer;
import com.masai.models.LoginDTO;
import com.masai.models.LoginSession;
import com.masai.models.Restaurant;
import com.masai.repository.CustomerRepository;
import com.masai.repository.LoginSessionRepository;
import com.masai.repository.RestaurantRepository;

import net.bytebuddy.utility.RandomString;



@Service
public class LoginSessionServiceImpl implements LoginSessionService {
	
	@Autowired
	private LoginSessionRepository loginRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	

	@Override
	public String customerLogin(LoginDTO lDto)throws LoginSessionException {
		

		Customer existingCustomer= customerRepo.findByMobileNumber(lDto.getMobileNumber());
		
				
		if(existingCustomer==null) {
			throw new LoginSessionException("Invalid mobile number...!!"); 
		}else {
			
			Optional<LoginSession> presentCustomer= loginRepo.findById(existingCustomer.getCustomerId());
			
			if(presentCustomer.isPresent()) {
				throw new LoginSessionException("Customer already exist the account..."); 
			}else {
				
				if (existingCustomer.getPassword() != null && existingCustomer.getPassword().equals(lDto.getPassword())) {
                    LoginSession customerSession = new LoginSession(existingCustomer.getCustomerId(),existingCustomer.getFirstName()+RandomString.make(1),LocalDateTime.now());

                    loginRepo.save(customerSession);

                    return customerSession.toString();
					
				}else {
					throw new LoginSessionException("Invalid password...!!");
				}
			}
			
		}
	}

//*******************************************************************************************************	
	
	@Override
	public String customerLogOut(String userName)throws LoginSessionException {
		
		LoginSession presentCustomer= loginRepo.findByUserName(userName);
		
		if(presentCustomer==null) {
			throw new LoginSessionException("Invalid user name...!!");
		}else {
			
			loginRepo.delete(presentCustomer);
			
			return "Customer logOut successfully...";
			
		}
		
	}
	
//*******************************************************************************************************
	
	@Override
	public String RestaturanLogin(LoginDTO lDto) throws LoginSessionException {
		
		Restaurant existingRestaurant=  restaurantRepo.findByMobileNumber(lDto.getMobileNumber());
		
		if(existingRestaurant==null) {
			throw new LoginSessionException("Invalid mobile number...!!");
		}else {
			
			 Optional<LoginSession> presentRestaurant=  loginRepo.findById(existingRestaurant.getRestaurantId());
			 
			 if(presentRestaurant.isPresent()) {
				 throw new LoginSessionException("Restaurant already exist...");
			 }else {
				 if (existingRestaurant.getPassword() != null && existingRestaurant.getPassword().equals(lDto.getPassword())) {
	                    LoginSession RestaurentSession = new LoginSession(existingRestaurant.getRestaurantId(),RandomString.make(4),LocalDateTime.now());

	                    loginRepo.save(RestaurentSession);

	                    return RestaurentSession.toString();
						
					}else {
						throw new LoginSessionException("Invalid password...!!");
					}
			 }
			
		}
		 
		
	}
	
//********************************************************************************************************
	
	@Override
	public String RestaturantLogOut(String userName) throws LoginSessionException {
         
		LoginSession presentRestaurant= loginRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user name...!!");
		}else {
			
			loginRepo.delete(presentRestaurant);
			
			return "Restaurant logOut successfully...";
			
		}
	}
	

	
	

//*******************************************************************************************************

	
}

package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.CustomerException;
import com.masai.models.Customer;
import com.masai.models.LoginSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.LoginSessionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;
	
//************************************************************************************************************
	@Override
	public String registerCustomer(Customer customer) throws CustomerException{
		
		Customer existingCustomer= customerRepo.findByMobileNumber(customer.getMobileNumber());
		
		if(existingCustomer!=null){
			throw new CustomerException("Customer alreday exist this number : "+customer.getMobileNumber());
		}else {
		    Customer savedCoustoemr= customerRepo.save(customer);
		    
		    return "customer register successfully with customerId = "+savedCoustoemr.getCustomerId();
		}
		
	}
	
//************************************************************************************************************
	
	@Override
	public Customer updateProfileDetails(String userName,Customer updatedCustomerDetails) throws CustomerException {
       
		LoginSession existingUser= loginSessionRepo.findByUserName(userName);
		
		if(existingUser==null) {
			throw new CustomerException("Invalid user name or Customer not exist the account...");
		}else {
			 return customerRepo.save(updatedCustomerDetails);
	
		}
		
		
       
	}

//************************************************************************************************************	
	
	@Override
	public String deleteAccount(Integer customerId, String userName) throws CustomerException {
        
		LoginSession existingUser= loginSessionRepo.findByUserName(userName);
		
		if(existingUser==null) {
			throw new CustomerException("Invalid user name or Customer not exist the account...");
		}else {
			   customerRepo.deleteById(customerId);
			   
			   return "account deleted successfully...";
	
		}
		
	}
	
//************************************************************************************************************

	@Override
	public Customer getAccountDetails(Integer customerId, String userName) throws CustomerException {
		
        LoginSession existingUser= loginSessionRepo.findByUserName(userName);
		
		if(existingUser==null) {
			throw new CustomerException("Invalid user name or Customer not exist the account...");
		}else {
			   Customer profileDetails= customerRepo.getById(customerId);
			   
			   return profileDetails;
	
		}
		
	}

}

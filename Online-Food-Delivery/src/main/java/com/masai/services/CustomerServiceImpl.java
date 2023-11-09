package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;
import com.masai.repositorys.CustomerRepository;
import com.masai.repositorys.LoginRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer cus) throws CustomerException {
		
		Customer customer=  customerRepo.findByMobileNumber(cus.getMobileNumber());
		
		if(customer !=null) {
			throw new CustomerException("Customer already exist with mobile number...");
		}else {
			Customer savedCustoemr= customerRepo.save(customer);
			
			return savedCustoemr;
		}

	}

}

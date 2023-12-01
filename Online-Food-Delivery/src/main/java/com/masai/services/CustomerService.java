package com.masai.services;

import com.masai.exception.CustomerException;
import com.masai.models.Customer;

public interface CustomerService {
	
	public String registerCustomer(Customer customer)throws CustomerException;
	
	public Customer updateProfileDetails(String userName,Customer updatedCustomerDetails)throws CustomerException;
	
	public String deleteAccount(String userName)throws CustomerException;
	
	public Customer getAccountDetails(String userName)throws CustomerException;
	
	
	
}

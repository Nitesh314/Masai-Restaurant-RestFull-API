package com.masai.services;

import com.masai.exceptions.CustomerException;
import com.masai.models.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer cus)throws CustomerException;

}

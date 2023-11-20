package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	public Customer findByMobileNumber(String mobileNumber);
	

	
}

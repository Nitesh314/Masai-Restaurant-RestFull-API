package com.masai.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	//using this first we check the customer is register or not;
	public Customer findByMobileNumber(String mobileNumber);

}

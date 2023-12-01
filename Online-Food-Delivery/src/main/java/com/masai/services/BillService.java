package com.masai.services;

import java.util.List;

import com.masai.exception.BillException;
import com.masai.exception.CustomerException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.Bill;

public interface BillService {
	
	public Bill createBillByRestaurant(String userName,Integer orederId)throws BillException,LoginSessionException,RestaurantException,OrderException;
	
	public Bill viewBillByCustomer(String userName,Integer orderId)throws LoginSessionException,OrderException;
	
	public List<Bill> viewAllBillsByCustomer(String userName) throws LoginSessionException,BillException ;
	
	public List<Bill>viewAllBillsByRestaurant(String userName)throws LoginSessionException,BillException;
	
	

}

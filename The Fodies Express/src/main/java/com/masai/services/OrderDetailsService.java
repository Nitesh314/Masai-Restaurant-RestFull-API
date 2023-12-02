package com.masai.services;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.Customer;
import com.masai.models.OrderDetails;

public interface OrderDetailsService {
	
	public OrderDetails addOrder(String userName,Integer cartId)throws LoginSessionException,FoodCartException,CustomerException;
	
	public OrderDetails removeOrderDetails(String userName,Integer orderId)throws LoginSessionException,OrderException ;
	
	public OrderDetails cancelOrder(String userName,Integer orderId )throws LoginSessionException,OrderException;

	
	//for restaurant use only...
	public List<OrderDetails> viewAllOrdersByRestaurant(String restaurantUserName)throws RestaurantException,OrderException;

	//for Customer use only...
	public List<OrderDetails>viewAllOrderByCustomer(String customerUserName)throws CustomerException,OrderException;
	
}

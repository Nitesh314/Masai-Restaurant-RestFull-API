package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.OrderDetails;
import com.masai.services.OrderDetailsService;

@RestController
@RequestMapping("/orders")
public class OrderDetailsControllerHandler {
	
	@Autowired
	private OrderDetailsService orderService;
	
//    public OrderDetails addOrder(String userName,Integer cartId)throws LoginSessionException,FoodCartException;
//	
//	public OrderDetails removeOrderDetails(String userName,Integer orderId)throws LoginSessionException,OrderException ;
//	
//	public OrderDetails cancelOrder(String userName,Integer orderId )throws LoginSessionException,OrderException;
//	
//	
//	//for restaurant use only...
//	public List<OrderDetails> viewAllOrdersByRestaurant(String restaurantUserName)throws RestaurantException,OrderException;
//
//	//for Customer use only...
//	public List<OrderDetails>viewAllOrderByCustomer(String customerUserName)throws CustomerException,OrderException;
	
	@PostMapping("/placeOrder/{userName}/{cartId}")
	public ResponseEntity<OrderDetails>placeOrder(@PathVariable("userName") String userName,@PathVariable("cartId") Integer cartId) throws LoginSessionException, FoodCartException, CustomerException{
		
		OrderDetails order = orderService.addOrder(userName, cartId);
		
		return new ResponseEntity<OrderDetails>(order,HttpStatus.CREATED);
		
	}

//**************************************************************************************************************************************************
	@DeleteMapping("/removeOrder/{userName}/{orderId}")
	public ResponseEntity<OrderDetails>removeOrderDetails(@PathVariable("userName") String userName,@PathVariable("orderId") Integer orderId) throws LoginSessionException, OrderException{
		
		OrderDetails removeOrder= orderService.removeOrderDetails(userName, orderId);
		
		return new ResponseEntity<OrderDetails>(removeOrder,HttpStatus.MOVED_PERMANENTLY);
		
	}

//*****************************************************************************************************************************************
	
	@PatchMapping("/cancelOrder/{userName}/{orderId}")
	public ResponseEntity<OrderDetails>cancelOrder(@PathVariable("userName") String userName,@PathVariable("orderId") Integer orderId) throws LoginSessionException, OrderException{
		
		OrderDetails cancelOrder= orderService.cancelOrder(userName, orderId);
		
		return new ResponseEntity<OrderDetails>(cancelOrder,HttpStatus.OK);
		
	}
	
//****************************************************************************************************************************************
	
	@GetMapping("/checkAllOrderByRestaurant/{userName}")
	public ResponseEntity<List<OrderDetails>>checkAllOrderDetailsByRestaurant(@PathVariable("userName") String restaurantUserName) throws RestaurantException, OrderException{
		
		List<OrderDetails>orderList= orderService.viewAllOrdersByRestaurant(restaurantUserName);
		
		return new ResponseEntity<List<OrderDetails>>(orderList,HttpStatus.OK);
	}
	
//******************************************************************************************************************************************	
	
	@GetMapping("/checkAllOrderDetailsByCustomer/{userName}")
	public ResponseEntity<List<OrderDetails>>checkAllOrderDetailsByCustomer(@PathVariable("userName") String customerUserName) throws CustomerException, OrderException{
		
		List<OrderDetails> orderList= orderService.viewAllOrderByCustomer(customerUserName);
		
		return new ResponseEntity<List<OrderDetails>>(orderList,HttpStatus.OK);
		
	}
   
}

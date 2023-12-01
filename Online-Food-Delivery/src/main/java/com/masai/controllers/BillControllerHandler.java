package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BillException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.Bill;
import com.masai.services.BillService;

@RestController
@RequestMapping("/bills")
public class BillControllerHandler {
	
	@Autowired
	private BillService billService;
	
//    public Bill createBillByRestaurant(String userName,Integer orederId)throws BillException,LoginSessionException,RestaurantException,OrderException;
//	
//	public Bill updateBillByRestaurant(String userName,Integer billId,Bill bill)throws BillException,LoginSessionException,RestaurantException;
//	
//	public Bill viewBillByCustomer(String userName,Integer orderId)throws LoginSessionException,OrderException;
//	
//	public List<Bill> viewAllBillsByCustomer(String userName) throws LoginSessionException,BillException ;
//	
//	public List<Bill>viewAllBillsByRestaurant(String userName)throws LoginSessionException,BillException;
	
	@PostMapping("/createBillByRestaurant/{userName}/{orderId}")
	public ResponseEntity<Bill> createBillByRestaurant(@PathVariable("userName") String userName,@PathVariable("orderId") Integer orderId) throws BillException, LoginSessionException, RestaurantException, OrderException{
		
		Bill createdBill= billService.createBillByRestaurant(userName, orderId);
		
		return new ResponseEntity<Bill>(createdBill,HttpStatus.CREATED);
		
	}
	

	
//****************************************************************************************************************
	
	@GetMapping("/getCustomerBill/{userName}/{orderId}")
	public ResponseEntity<Bill>getBillByCustomer(@PathVariable("userName") String userName,@PathVariable("orderId") Integer orderId) throws LoginSessionException, OrderException{
		
		Bill customerBill= billService.viewBillByCustomer(userName, orderId);
		
		return new ResponseEntity<Bill>(customerBill,HttpStatus.OK);
	}
	
//***************************************************************************************************************
	@GetMapping("/viewAllCustomerBill/{userName}")
	public ResponseEntity<List<Bill>>getAllBillByCustomer(@PathVariable("userName") String customerUserName) throws LoginSessionException, BillException{
		
		List<Bill>customerBillList= billService.viewAllBillsByCustomer(customerUserName);
		
		return new ResponseEntity<List<Bill>>(customerBillList,HttpStatus.OK);
	}
	
//***************************************************************************************************************	
	
	@GetMapping("/viewAllRestaurantBill/{userName}")
	public ResponseEntity<List<Bill>>getAllBillByRestaurant(@PathVariable("userName") String restaurantUserName) throws LoginSessionException, BillException{
		
		List<Bill>customerBillList= billService.viewAllBillsByRestaurant(restaurantUserName);
		
		return new ResponseEntity<List<Bill>>(customerBillList,HttpStatus.OK);
	}

}

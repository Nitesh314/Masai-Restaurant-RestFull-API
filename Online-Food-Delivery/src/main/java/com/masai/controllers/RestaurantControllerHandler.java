package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.models.Restaurant;
import com.masai.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantControllerHandler {
	
	@Autowired
	private RestaurantService restaurantService;
	
//    public String registerRestaurant(Restaurant restaurant)throws RestaurantException;
//	
//	public Restaurant updateRestaurantDetails(String userName, Restaurant updatedRestaurant)throws RestaurantException;
// 
//	public String removeRestaurantAccount(String userName,Integer restaurantId)throws RestaurantException;
//	
//	public Restaurant getRestaurantDetails(Integer restaurantId)throws RestaurantException;
//	
//	public List<Item>getAllItemDetails()throws RestaurantException;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
		
		String registerResult= restaurantService.registerRestaurant(restaurant);
		
		return new ResponseEntity<String>(registerResult,HttpStatus.OK);
		
	}
//*****************************************************************************************************************
	
	@PutMapping("/update/{userName}")
	public ResponseEntity<Restaurant>updateRestaurant(@PathVariable("userName") String userName,@RequestBody Restaurant updatedRestaurant) throws RestaurantException{
		
		Restaurant updatedRestaurantDetails= restaurantService.updateRestaurantDetails(userName, updatedRestaurant);
		
		return new ResponseEntity<Restaurant>(updatedRestaurantDetails,HttpStatus.OK);
	}

//******************************************************************************************************************
	
	@DeleteMapping("delete/{userName}/{restaurantId}")
	public ResponseEntity<String>removeAccount(@PathVariable("userName") String usrName,@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		
		String removeResult= restaurantService.removeRestaurantAccount(usrName, restaurantId);
		
		return new ResponseEntity<String>(removeResult,HttpStatus.MOVED_PERMANENTLY);
	}
	
//*******************************************************************************************************************
	@GetMapping("/get/{restaurnatsId}")
	public ResponseEntity<Restaurant>getRstaurantDetails(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		
		Restaurant restaurantDetails= restaurantService.getRestaurantDetails(restaurantId);
		
		return new ResponseEntity<Restaurant>(restaurantDetails,HttpStatus.OK);
		
	}
//*********************************************************************************************************************
	
	@GetMapping("/getAllItems/{restaurantId}")
	public ResponseEntity<List<Item>>getAllItems(Integer restaurantId) throws RestaurantException, ItemException{
		
	 	List<Item>itemList= restaurantService.getAllItemDetails(restaurantId);
	 	
	 	return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
		
	}

}

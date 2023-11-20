package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.models.LoginSession;
import com.masai.models.Restaurant;
import com.masai.repository.LoginSessionRepository;
import com.masai.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;
	
	
	@Override
	public String registerRestaurant(Restaurant restaurant) throws RestaurantException {
		
		Restaurant existingRestaurant= restaurantRepo.findByMobileNumber(restaurant.getMobileNumber());
		
		if(existingRestaurant!=null) {
			throw new RestaurantException("Restaurant already register with mobile number...!!!");
		}else {
			Restaurant savedRestaurant= restaurantRepo.save(restaurant);
			
			return savedRestaurant.getRestaurantName()+" Register successfully....";
		}
		
	}
	
//**********************************************************************************************************
	
	@Override
	public Restaurant updateRestaurantDetails(String userName, Restaurant updatedRestaurant)throws RestaurantException{
	 
		LoginSession presentRestaurantSession= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurantSession==null) {
			throw new RestaurantException("Invalid user name...!!!");
		}else {
			Restaurant updatedRestaurantDetails= restaurantRepo.save(updatedRestaurant);
			
			return updatedRestaurantDetails;
		}
	
	
	}

//**********************************************************************************************************	
	
	@Override
	public String removeRestaurantAccount(String userName, Integer restaurantId) throws RestaurantException {
         
		LoginSession presentRestaurantSession= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurantSession==null) {
			throw new RestaurantException("Invalid user name...!!!");
		}else {
			
			restaurantRepo.deleteById(restaurantId);
			
			return  "Account deleted successfully...";			
		}
		
		
	}
	
//**********************************************************************************************************

	@Override
	public Restaurant getRestaurantDetails(Integer restaurantId) throws RestaurantException {
		
		 Restaurant restaurantDetails= restaurantRepo.findById(restaurantId).orElseThrow(()->new RestaurantException("Invalid restaurantId...!!!"));
		
		return restaurantDetails;
		
	}

//**********************************************************************************************************
	 
	@Override
	public List<Item> getAllItemDetails(Integer restaurantId) throws RestaurantException,ItemException {
		
		Optional<Restaurant> existingRestaurant= restaurantRepo.findById(restaurantId);
		
		if(existingRestaurant==null) {
			throw new RestaurantException("Invalid restaurant Id...!!!");
		}else {
			 List<Item>itemList= restaurantRepo.getAllItemsfromRestorant(restaurantId);
			 
			 if(itemList.isEmpty()||itemList==null) {
				 throw new ItemException("Sorry, we don't have any items...");
			 }else {
				 return itemList;
			 }
		}
		
	}

}

package com.masai.services;



import java.util.List;

import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.models.Restaurant;




public interface RestaurantService {
	
	public String registerRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurantDetails(String userName, Restaurant updatedRestaurant)throws RestaurantException;
 
	public String removeRestaurantAccount(String userName,Integer restaurantId)throws RestaurantException;
	
	public Restaurant getRestaurantDetails(Integer restaurantId)throws RestaurantException;
	
	public List<Item>getAllItemDetails(Integer restaurantId)throws RestaurantException,ItemException;
	
}


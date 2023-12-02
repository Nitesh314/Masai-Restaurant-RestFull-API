package com.masai.services;



import java.util.List;

import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.models.Restaurant;




public interface RestaurantService {
	
	public String registerRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurantDetails(String userName, Restaurant updatedRestaurant)throws RestaurantException,LoginSessionException;
 
	public String removeRestaurantAccount(String userName)throws RestaurantException,LoginSessionException;
	
	public Restaurant getRestaurantDetails(String userName)throws LoginSessionException,RestaurantException;
	
	public List<Item>getAllItemDetails(String userName)throws RestaurantException,ItemException,LoginSessionException;
	
}


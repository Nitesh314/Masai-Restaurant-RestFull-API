package com.masai.services;

import java.util.List;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;

public interface ItemService {
	
	//all task for restaurants staff only...
	
	public String addItem(String userName, Item item)throws ItemException,RestaurantException,LoginSessionException;
	
	public Item updateItem(String userName,Item updatedItem)throws ItemException,RestaurantException,LoginSessionException;
	
	public String removeItem(String userName,Integer itemId)throws ItemException,RestaurantException,LoginSessionException;
	
	public List<Item>getAllItemDetails(String userName)throws ItemException,RestaurantException,LoginSessionException;
	
    public List<Item>getAllItemByName(String itemName)throws ItemException;
    
    public List<Item>getAllItemByRestaurantName(String restaurantName) throws RestaurantException,ItemException;
    
    public List<Item>getAllItemByCategory(String categoryName)throws ItemException,CategoryException;
    

}

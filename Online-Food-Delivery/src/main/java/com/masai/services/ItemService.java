package com.masai.services;

import java.util.List;


import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;

public interface ItemService {
	
	//all task for restaurants staff only...
	
	public String addItem(Integer restaurantId, Item item)throws ItemException,RestaurantException;
	
	public Item updateItem(Integer restaurantId,Item updatedItem)throws ItemException,RestaurantException;
	
	public String removeItem(Integer restaurantId,Integer itemId)throws ItemException,RestaurantException;
	
	public List<Item>getAllItemDetails(Integer restaurantId)throws ItemException,RestaurantException;
	
	

}

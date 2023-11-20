package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ItemException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.models.Restaurant;
import com.masai.repository.ItemRepository;
import com.masai.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	

	@Override
	public String addItem(Integer restaurantId, Item item) throws ItemException,RestaurantException {
		
		Optional<Restaurant> existingRestaurant= restaurantRepo.findById(restaurantId);
		
		if(existingRestaurant==null) {
			throw new RestaurantException("Restaurant not exist,Invalid restaurant Id...!!!");
		}else {
			Item registerItem= itemRepo.save(item);
			
			if(registerItem==null) {
				throw new ItemException("Item not added in restaurant...");
			}else {
				return "Item "+registerItem.getItemName()+"added successfully in "+existingRestaurant.get().getRestaurantName()+"restaurant";
			}
			
			
		}
		
	}
//*****************************************************************************************************
	@Override
	public Item updateItem(Integer restaurantId, Item updatedItem) throws ItemException,RestaurantException {
        
		Optional<Restaurant> existingRestaurant= restaurantRepo.findById(restaurantId);
		
		if(existingRestaurant==null) {
			throw new RestaurantException("Restaurant not exist,Invalid restaurant Id...!!!");
		}else {
			
			Item updateItmeDetails= itemRepo.save(updatedItem);
			
			if(updatedItem==null) {
				throw new ItemException("Item not updated...");
			}else {
				return updateItmeDetails;
			}
			
			
		}

	}
//*****************************************************************************************************
	@Override
	public String removeItem(Integer restaurantId, Integer itemId) throws ItemException,RestaurantException {
        
		Optional<Restaurant> existingRestaurant= restaurantRepo.findById(restaurantId);
		
		if(existingRestaurant==null) {
			throw new RestaurantException("Restaurant not exist,Invalid restaurant Id...!!!");
		}else {
			
			itemRepo.deleteById(itemId);
			
			return "Itme remove successfully...";
			
		}

	}
//*****************************************************************************************************
	@Override
	public List<Item> getAllItemDetails(Integer restaurantId) throws ItemException,RestaurantException {
        
		 Optional<Restaurant> existingRestaurant= restaurantRepo.findById(restaurantId);
		
		if(existingRestaurant==null) {
			throw new RestaurantException("Restaurant not exist,Invalid restaurant Id...!!!");
		}else {
			
			 List<Item>allItem= itemRepo.findAll();
			 
			 if (allItem == null || allItem.isEmpty()) {
				    throw new ItemException("Sorry, we don't have any items...");
			}else {
				return allItem;
			}
			
		}
		

	}

}

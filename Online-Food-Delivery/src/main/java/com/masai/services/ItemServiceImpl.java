package com.masai.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.RestaurantException;

import com.masai.models.Item;
import com.masai.models.LoginSession;
import com.masai.models.Restaurant;

import com.masai.repository.ItemRepository;
import com.masai.repository.LoginSessionRepository;
import com.masai.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private LoginSessionRepository loginRepo;
	

	@Override
	public String addItem(String userName, Item item) throws ItemException,RestaurantException,LoginSessionException {
		
		
		LoginSession presentRestaurant= loginRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user name...");
		}else {
			
			Optional<Restaurant> existingRestaurant= restaurantRepo.findById(presentRestaurant.getLoginId());
			
			if(existingRestaurant.isPresent()) {
				
				existingRestaurant.get().getItemList().add(item);
				
				return "Item added successFully...";
				
			}else {
				throw new RestaurantException("Item not added...");
			}
			
		}
		
		
		
	}
//*****************************************************************************************************
	@Override
	public Item updateItem(String userName, Item updatedItem) throws ItemException,RestaurantException,LoginSessionException {
		
		
		
		 LoginSession presentRestaurant = loginRepo.findByUserName(userName);

		    if (presentRestaurant == null) {
		        throw new LoginSessionException("Invalid user name...");
		    } else {

		        Optional<Restaurant> existingRestaurant = restaurantRepo.findById(presentRestaurant.getLoginId());

		        if (existingRestaurant.isPresent()) {

		            boolean itemUpdated = false;

		            for (Item currentItem : existingRestaurant.get().getItemList()) {
		                if (currentItem.getItemId().equals(updatedItem.getItemId())) {
		                    // Update the item details
		                    currentItem.setCategory(updatedItem.getCategory());
		                    currentItem.setCost(updatedItem.getCost());
		                    currentItem.setItemName(updatedItem.getItemName());
		                    currentItem.setQuantity(updatedItem.getQuantity());
		                    currentItem.setRestaurants(updatedItem.getRestaurants());

		                    // Save the updated item
		                    itemRepo.save(currentItem);

		                    itemUpdated = true;
		                    break;
		                }
		            }

		            if (!itemUpdated) {
		                throw new ItemException("Item not found for update...");
		            }

		            return updatedItem; // Return the updated item
		        } else {
		            throw new RestaurantException("Restaurant not found...");
		        }
		    }
			
		
		

	}
//*****************************************************************************************************
	@Override
	public String removeItem(String userName, Integer itemId) throws ItemException,RestaurantException,LoginSessionException {
		
		String msg="Item not deleted...";
		
		LoginSession presentRestaurant= loginRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user name...");
		}else {
			
			Optional<Restaurant> op= restaurantRepo.findById(presentRestaurant.getLoginId());
			
			if(op.isPresent()) {
			    
				Restaurant existingRestaurant= op.get();
				
				for(Item i:existingRestaurant.getItemList()){
					
					if(i.getItemId()==itemId) {
					   itemRepo.delete(i);
					  
					   msg=i.getItemName()+"deleted successfully with item id "+i.getItemId();
					   
					}else {
						throw new ItemException("Invalid item id...."); 
					}
					
				}
				
				
			}
		
			return msg;
		}
        
		

	}
//*****************************************************************************************************
	@Override
	public List<Item> getAllItemDetails(String userName) throws ItemException,RestaurantException,LoginSessionException {
        
		LoginSession presentRestaurant= loginRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user name...");
		}else {
			
			List<Item> itemList= itemRepo.getAllItemByRestaurantId(presentRestaurant.getLoginId());
			
			if(itemList.isEmpty()) {
				throw new ItemException("Sorry !! we not have any Item...") ;
			}else {
				return itemList;
			}
			
		}
		
		
		 
			
		
		

	}
//***************************************************************************************************************	
	@Override
	public List<Item> getAllItemByName(String itemName) throws ItemException {
		
		List<Item>itemList= itemRepo.findByItemName(itemName);
		
		if(itemList.isEmpty()||itemList==null) {
			throw new ItemException("Sorry "+itemName+" not available this time....");
		}else {
			return itemList;
		}
		
	}
//************************************************************************************************************	
	@Override
	public List<Item> getAllItemByRestaurantName(String restaurantName) throws RestaurantException, ItemException {
        
		List<Item> itemList;
		
		Restaurant restaurant= restaurantRepo.findByRestaurantName(restaurantName);
		
		
			
			if(restaurant.getRestaurantName().equalsIgnoreCase(restaurantName)& restaurant!=null) {
				
				   itemList=restaurant.getItemList();
				   
				   if(itemList==null) {
					   throw new ItemException("Sorry we dont have food....");
				   }else {
					   return itemList;
				   }
				}else {
					throw new RestaurantException(restaurantName+" not found...");
				}
			
		
		
		
		
	}
//**********************************************************************************************************	
	@Override
	public List<Item> getAllItemByCategory(String categoryName) throws ItemException, CategoryException {
		
	   List<Item>itemList= itemRepo.findByCategory(categoryName);
		
	   if(itemList==null) {
		   throw new CategoryException("Provide the correct category name...");
	   }else if(itemList.isEmpty()) {
		   throw new ItemException(categoryName+" category item not available...");
	   }else {
		   return itemList;
	   }
	   
	}

}

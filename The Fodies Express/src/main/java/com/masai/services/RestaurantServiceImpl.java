package com.masai.services;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
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
//				  Category category= new Category();
//				  
//				  for(Item i:restaurant.getItemList()) {
//					  
//					  category.setCategoryId(i.getCategory().getCategoryId());
//					  category.setCategoryName(i.getCategory().getCategoryName());
//					  
//				  }
			      
				 
				  
			Restaurant savedRestaurant= restaurantRepo.save(restaurant);
			
			return savedRestaurant.getRestaurantName()+" Register successfully with restaurant id : "+savedRestaurant.getRestaurantId();
		}
		
	}
	
//**********************************************************************************************************
	
	@Override
	public Restaurant updateRestaurantDetails(String userName, Restaurant updatedRestaurant)throws RestaurantException,LoginSessionException{
	 
		 LoginSession presentRestaurantSession = loginSessionRepo.findByUserName(userName);

		    if (presentRestaurantSession == null) {
		        throw new LoginSessionException("Invalid user-name...!!!");
		    } else {

		        Optional<Restaurant> op = restaurantRepo.findById(presentRestaurantSession.getLoginId());

		        if (op.isPresent()) {

		            Restaurant existingRestaurant = op.get();

		      
		            
		            // Update simple attributes
		            existingRestaurant.setAddress(updatedRestaurant.getAddress());
		            existingRestaurant.setManagerName(updatedRestaurant.getManagerName());
		            existingRestaurant.setMobileNumber(updatedRestaurant.getMobileNumber());
		            existingRestaurant.setPassword(updatedRestaurant.getPassword());
		            existingRestaurant.setRestaurantName(updatedRestaurant.getRestaurantName());

		            // Update or add items individually
		            for (Item updatedItem : updatedRestaurant.getItemList()) {
		                // Check if the item already exists
		                Optional<Item> existingItem = existingRestaurant.getItemList().stream()
		                        .filter(item -> item.getItemId().equals(updatedItem.getItemId()))
		                        .findFirst();

		                if (existingItem.isPresent()) {
		                    // Update existing item
		                    Item currentItem = existingItem.get();
		                    currentItem.setItemName(updatedItem.getItemName());
		                    currentItem.setQuantity(updatedItem.getQuantity());
		                    currentItem.setCost(updatedItem.getCost());
		                    // Update other fields as needed
		                } else {
		                    // Add new item
		                    existingRestaurant.getItemList().add(updatedItem);
		                }
		            }

		            // Handle orphan removal
		            existingRestaurant.getItemList().removeIf(item -> !updatedRestaurant.getItemList().contains(item));

		            // Save the updated restaurant
		            Restaurant updatedRestaurantDetails = restaurantRepo.save(existingRestaurant);

		            return updatedRestaurantDetails;
		        } else {
		            throw new RestaurantException("Restaurant details not updated...");
		        }
		    }
	
	}

//**********************************************************************************************************	
	
	@Override
	public String removeRestaurantAccount(String userName) throws RestaurantException,LoginSessionException {
         
		LoginSession presentRestaurantSession= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurantSession==null) {
			throw new LoginSessionException("Invalid user name...!!!");
		}else {
			
			restaurantRepo.deleteById(presentRestaurantSession.getLoginId());
			loginSessionRepo.deleteById(presentRestaurantSession.getLoginId());
			
			return  "Account deleted successfully...";			
		}
		
		
	}
	
//**********************************************************************************************************

	@Override
	public Restaurant getRestaurantDetails(String userName) throws RestaurantException,LoginSessionException {
		
		LoginSession presentRestaurant= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user-name...");
		}else {
			 Restaurant restaurantDetails= restaurantRepo.findById(presentRestaurant.getLoginId()).orElseThrow(()->new RestaurantException("Invalid restaurant Id...!!!"));
				
			 return restaurantDetails;
		}
		
		
		
	}

//**********************************************************************************************************
	 
	@Override
	public List<Item> getAllItemDetails(String userName) throws RestaurantException,ItemException,LoginSessionException {
		
		LoginSession presentRestaurant= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid user-name...");
		}else {
			
				 List<Item>itemList= restaurantRepo.getAllItemsfromRestorant(presentRestaurant.getLoginId());
				 
				 if(itemList.isEmpty()||itemList==null) {
					 throw new ItemException("Sorry, we don't have any items...");
				 }else {
					 return itemList;
				 }
			}
			
		}

}

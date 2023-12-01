package com.masai.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.models.Customer;
import com.masai.models.FoodCart;
import com.masai.models.Item;
import com.masai.models.LoginSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.FoodCartRepository;
import com.masai.repository.ItemRepository;
import com.masai.repository.LoginSessionRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService {
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private FoodCartRepository foodCartRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public String addItemInCart(String userName, Integer itemId) throws LoginSessionException, FoodCartException,CustomerException, ItemException {
		
		
		
		
	 	LoginSession presentUser= loginSessionRepo.findByUserName(userName);
	 	
	 	if(presentUser==null) {
	 		throw new LoginSessionException("Invalid user name,use correct user name to login the account...");
	 	}else {
	 		
	 		FoodCart foodCart=new FoodCart();
	 		
	 		Optional<Item> item= itemRepo.findById(itemId);
	 		
	 		if(item.isPresent()) {
	 			
	 			Customer presentCustomer= customerRepo.findById(presentUser.getLoginId()).orElseThrow(()->new CustomerException("customer not found..."));
		 		
		 		foodCart.setCustomer(presentCustomer);
		 		
		 		foodCart.getItemList().add(item.get());
		 		
		 		foodCartRepo.save(foodCart);
		 		
		 		return "saved";
	 			
	 		}else {
	 			throw new ItemException("Invalid itemId...");
	 		}
	 		
	 		
	 		
	 	}
		
		
	}
	
//****************************************************************************************************************
	@Override
	public FoodCart removeItemToCart(String userName, Integer cartId, Integer itemId)throws LoginSessionException, ItemException, FoodCartException {
		
		LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name, use correct user name to login the account");
		}else {
			
			Optional<FoodCart> presentFoodCart= foodCartRepo.findById(cartId);
			
			if(presentFoodCart.isPresent()) {
				
                  Item presentItem= foodCartRepo.findByItemId(itemId);
                  
                  if(presentItem!=null) {
                	   boolean item= presentFoodCart.get().getItemList().remove(presentItem);
                	   
                	    FoodCart removeItemfoodCart= foodCartRepo.save(presentFoodCart.get());
                	   
                	   
                	   if(item) {
                		   return removeItemfoodCart;
                	   }else {
                		   throw new ItemException("Item not removed...");
                	   }
                  }else {
                	  throw new ItemException("Invalid item id...");
                  }
				
			}else {
				throw new FoodCartException("Invalid cart id...");
			}
			
		} 
		
	}

//******************************************************************************************************************	
	
	@Override
	public FoodCart increaseItemQuantity(String userName,Integer cartId, Integer itemId, Integer quantity) throws LoginSessionException, FoodCartException, ItemException {
		
        LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name, use correct user name to login the account");
		}else {
			
			Optional<FoodCart> presentFoodCart= foodCartRepo.findById(cartId);
			
			if(presentFoodCart.isPresent()) {
				
                  Item presentItem= foodCartRepo.findByItemId(itemId);
                  
                  if(presentItem!=null) {
                	        
                	  presentItem.setQuantity(presentItem.getQuantity()+quantity);
                	  
                	  FoodCart increaseQuantityFoodCart= foodCartRepo.save(presentFoodCart.get());
                	  
                	  return increaseQuantityFoodCart;
                	 
                  }else {
                	  throw new ItemException("Invalid item id...");
                  }
				
			}else {
				throw new FoodCartException("Invalid cart id...");
			}
			
		} 
		
	}

//******************************************************************************************************************
	
	@Override
	public FoodCart decreaseItemQuantity(String userName,Integer cartId, Integer itemId, Integer quantity)	throws LoginSessionException, FoodCartException, ItemException {
		
        LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name, use correct user name to login the account");
		}else {
			
			Optional<FoodCart> presentFoodCart= foodCartRepo.findById(cartId);
			
			if(presentFoodCart.isPresent()) {
				
                  Item presentItem= foodCartRepo.findByItemId(itemId);
                  
                  if(presentItem!=null) {
                	        
                	  presentItem.setQuantity(presentItem.getQuantity()-quantity);
                	  
                      FoodCart dncreaseQuantityFoodCart= foodCartRepo.save(presentFoodCart.get());
                	  
                	  return dncreaseQuantityFoodCart;
                	 
                  }else {
                	  throw new ItemException("Invalid item id...");
                  }
				
			}else {
				throw new FoodCartException("Invalid cart id...");
			}
			
		} 
		
	}
	
//*******************************************************************************************************************	

	@Override
	public FoodCart viewFoodCart(String userName, Integer cartId) throws FoodCartException, LoginSessionException {
		
		LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name,use valid user name for login the account...");
		}else {
			Optional<FoodCart> presentFoodCart=foodCartRepo.findById(cartId);
			
			if(presentFoodCart.isPresent()) {
				return presentFoodCart.get();
			}else {
				throw new FoodCartException("Invalid cartId...");
			}
			
		}
		
	}
	
//*******************************************************************************************************************	

	@Override
	public FoodCart clearFoodCart(String userName, Integer cartId) throws LoginSessionException, FoodCartException {
		
        LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name,use valid user name for login the account...");
		}else {
			Optional<FoodCart> presentFoodCart=foodCartRepo.findById(cartId);
			
			if(presentFoodCart.isPresent()) {
				
				foodCartRepo.delete(presentFoodCart.get());
				return presentFoodCart.get();
			}else {
				throw new FoodCartException("Invalid cartId...");
			}
			
		}

		
	}

}

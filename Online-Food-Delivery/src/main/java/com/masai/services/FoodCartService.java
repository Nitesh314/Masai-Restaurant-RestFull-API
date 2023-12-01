package com.masai.services;
import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.models.FoodCart;
import com.masai.models.Item;

public interface FoodCartService {
	
    // addItem , remove Item, increaseQuantity,decresQuantity,clear cart,view cart;
	
	public String addItemInCart(String userName,Integer itemId)throws LoginSessionException,FoodCartException,CustomerException,ItemException ;
	
    public FoodCart removeItemToCart(String userName,Integer cartId ,Integer itemId)throws LoginSessionException ,ItemException,FoodCartException;
    
    public FoodCart increaseItemQuantity(String userName,Integer cartId ,Integer itemId ,Integer quantity)throws LoginSessionException,FoodCartException,ItemException;
    
    public FoodCart decreaseItemQuantity(String userName,Integer cartId ,Integer itemId,Integer quantity )throws LoginSessionException,FoodCartException,ItemException;
    
    public FoodCart viewFoodCart(String userName, Integer cartId)throws FoodCartException,LoginSessionException;
    
    public FoodCart clearFoodCart(String userName,Integer cartId)throws LoginSessionException,FoodCartException;
	
	 
}

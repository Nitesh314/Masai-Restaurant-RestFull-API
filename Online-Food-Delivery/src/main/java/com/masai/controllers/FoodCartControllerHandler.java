package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.models.FoodCart;
import com.masai.services.FoodCartService;

@RestController
@RequestMapping("/FoodCart")
public class FoodCartControllerHandler {
	
	@Autowired
	private FoodCartService foodCartService;
	
//	public String addItemInCart(String userName,Integer itemId)throws LoginSessionException,FoodCartException,CustomerException,ItemException ;
//	
//    public FoodCart removeItemToCart(String userName,Integer cartId ,Integer itemId)throws LoginSessionException ,ItemException,FoodCartException;
//    
//    public FoodCart increaseItemQuantity(String userName,Integer cartId ,Integer itemId ,Integer quantity)throws LoginSessionException,FoodCartException,ItemException;
//    
//    public FoodCart decreaseItemQuantity(String userName,Integer cartId ,Integer itemId,Integer quantity )throws LoginSessionException,FoodCartException,ItemException;
//    
//    public FoodCart viewFoodCart(String userName, Integer cartId)throws FoodCartException,LoginSessionException;
//    
//    public FoodCart clearFoodCart(String userName,Integer cartId)throws LoginSessionException,FoodCartException;
	
	@PostMapping("/insertItem/{userName}/{itemId}")
	public ResponseEntity<String> addItemInCart(@PathVariable("userName") String userName,@PathVariable("itemId") Integer itemId) throws LoginSessionException, FoodCartException, CustomerException, ItemException{
		
		String result= foodCartService.addItemInCart(userName, itemId);
		
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	
//**************************************************************************************************************
	
	@DeleteMapping("removeItemInCart/{userName}/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> removeItemToCart(@PathVariable("userName") String userName,@PathVariable("cartId") Integer cartId,@PathVariable("itemId") Integer itemId) throws LoginSessionException, ItemException, FoodCartException{
		
		FoodCart itemRemoveFoodCart= foodCartService.removeItemToCart(userName, cartId, itemId);
		
		return new ResponseEntity<FoodCart>(itemRemoveFoodCart,HttpStatus.MOVED_PERMANENTLY);
		
	}
	
//**************************************************************************************************************
	@PatchMapping("increaseItemQuantity/{userName}/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>increaseItemQuantity(@PathVariable("userName") String userName,@PathVariable("cartId") Integer cartId ,@PathVariable("itemId") Integer itemId ,@PathVariable("quantity") Integer quantity) throws LoginSessionException, FoodCartException, ItemException{
		
		FoodCart foodCart= foodCartService.increaseItemQuantity(userName, cartId, itemId, quantity);
		
		return new ResponseEntity<FoodCart>(foodCart,HttpStatus.OK);
		
	}

//****************************************************************************************************************
	
	@PatchMapping("decreaseItemQuantity/{userName}/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>decreaseItemQuantity(@PathVariable("userName") String userName,@PathVariable("cartId") Integer cartId ,@PathVariable("itemId") Integer itemId ,@PathVariable("quantity") Integer quantity) throws LoginSessionException, FoodCartException, ItemException{
		
		FoodCart foodCart= foodCartService.decreaseItemQuantity(userName, cartId, itemId, quantity);
		
		return new ResponseEntity<FoodCart>(foodCart,HttpStatus.OK);
		
	}
//*********************************************************************************************************************	

	@GetMapping("viewFoodCart/{userName}/{cartId}")
	public ResponseEntity<FoodCart>viewFoodCart(String userName, Integer cartId) throws FoodCartException, LoginSessionException{
		
		FoodCart foodCart= foodCartService.viewFoodCart(userName, cartId);
		
		return new ResponseEntity<FoodCart>(foodCart,HttpStatus.OK);
	}

//***********************************************************************************************************************
	
	@DeleteMapping("clearFoodCart/{userName}/{cartId}")
	public ResponseEntity<FoodCart>clearFoodCart(String userName, Integer cartId) throws FoodCartException, LoginSessionException{
		
		FoodCart foodCart= foodCartService.clearFoodCart(userName, cartId);
		
		return new ResponseEntity<FoodCart>(foodCart,HttpStatus.OK);
	}
	
	
	
}

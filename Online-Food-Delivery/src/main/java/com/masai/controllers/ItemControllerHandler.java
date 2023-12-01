package com.masai.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CategoryException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.RestaurantException;
import com.masai.models.Item;
import com.masai.services.ItemService;

@RestController
@RequestMapping("/Items")
public class ItemControllerHandler {
    
	@Autowired
	private ItemService itemService;
	
//    public String addItem(Integer restaurantId, Item item)throws ItemException,RestaurantException;
//	
//	public Item updateItem(Integer restaurantId,Item updatedItem)throws ItemException,RestaurantException;
//	
//	public String removeItem(Integer restaurantId,Integer itemId)throws ItemException,RestaurantException;
//	
//	public List<Item>getAllItemDetails(Integer restaurantId)throws ItemException,RestaurantException;

//	 public List<Item>getAllItemByName(String itemName)throws ItemException;
//	    
//	 public List<Item>getAllItemByRestaurantName(String restaurantName) throws RestaurantException,ItemException;
//	    
//	 public List<Item>getAllItemByCategory(String categoryName)throws ItemException,CategoryException;
	
	@PostMapping("/createItem/{userName}")
	public ResponseEntity<String>createItem(@PathVariable ("userName")String userName ,@RequestBody Item item) throws ItemException, RestaurantException, LoginSessionException{
		
		String itemResult= itemService.addItem(userName,item);
		
		return new ResponseEntity<String>(itemResult,HttpStatus.CREATED);
		
	}
//**************************************************************************************************************
	
	@PutMapping("/update/{userName}")
	public ResponseEntity<Item>updateItmes(@PathVariable ("userName") String userName,@RequestBody Item updatedItem) throws ItemException, RestaurantException, LoginSessionException{
		
		Item updatedItemEntity= itemService.updateItem(userName, updatedItem);
		
		return new ResponseEntity<Item>(updatedItemEntity,HttpStatus.OK);
		
	}

//**************************************************************************************************************
	@DeleteMapping("/delete/{userName}/{itemId}")
	public ResponseEntity<String>removeItem(@PathVariable ("userName") String userName,@PathVariable("itemId") Integer itemId) throws ItemException, RestaurantException, LoginSessionException{
		
		String result= itemService.removeItem(userName, itemId);
		
		return new ResponseEntity<String>(result,HttpStatus.MOVED_PERMANENTLY);
		
	}
	
//***************************************************************************************************************
	
	@GetMapping("/getAllItems/{userName}")
	public ResponseEntity<List<Item>>getAllItemDetails(@PathVariable("userName") String userName) throws ItemException, RestaurantException, LoginSessionException{
		
		List<Item> itemList= itemService.getAllItemDetails(userName);
		
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
	}
//****************************************************************************************************************
	
	@GetMapping("/getItemByName/{itemName}")
	public ResponseEntity<List<Item>>getAllItemByName(@PathVariable("itemName") String itemName) throws ItemException{
		
		List< Item> itemList= itemService.getAllItemByName(itemName);
		
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
		
	}
	
//****************************************************************************************************************
	
	@GetMapping("/getItemByRestaurantName/{restaurantName}")
	public ResponseEntity<List<Item>>getAllItemByRestaurantName(@PathVariable("restaurantName") String restaurantName) throws ItemException, RestaurantException{
		
		List< Item> itemList= itemService.getAllItemByRestaurantName(restaurantName);
		
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
		
	}
	
//******************************************************************************************************************	
	
	@GetMapping("/getItemByCategoryName/{categoryName}")
	public ResponseEntity<List<Item>>getAllItemByCategoryName(@PathVariable("categoryName") String categoryName) throws ItemException, CategoryException{
		
		List< Item> itemList= itemService.getAllItemByCategory(categoryName);
		
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
		
	}
	
}

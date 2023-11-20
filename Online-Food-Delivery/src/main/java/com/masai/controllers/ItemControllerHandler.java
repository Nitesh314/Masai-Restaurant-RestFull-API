package com.masai.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ItemException;
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
	
	@PostMapping("/createItem/{restaurantId}")
	public ResponseEntity<String>createItem(@PathVariable Integer restaurantId ,@RequestBody Item item) throws ItemException, RestaurantException{
		
		String itemResult= itemService.addItem(restaurantId,item);
		
		return new ResponseEntity<String>(itemResult,HttpStatus.OK);
		
	}
	
	
}

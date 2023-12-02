package com.masai.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.masai.models.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {
	
	public List<Item> findByItemName(String itemName);
	
	
	public  List<Item> findByCategory(String categoryName);
	
	@Query("Select i from Item i Inner Join i.restaurants r where r.restaurantId=?1")
    public List<Item> getAllItemByRestaurantId(Integer restaurantId);

}

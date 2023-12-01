package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.Item;
import com.masai.models.Restaurant;



public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
	
	public Restaurant findByMobileNumber(String contactNumber);
	
	public  Restaurant findByRestaurantName(String restaurantName);
		
	@Query("select r.itemList from Restaurant r where r.restaurantId=?1")
    public List<Item> getAllItemsfromRestorant(Integer restaurantId);
	
	

}

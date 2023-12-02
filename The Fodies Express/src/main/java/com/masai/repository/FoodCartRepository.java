package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.FoodCart;
import com.masai.models.Item;

public interface FoodCartRepository extends JpaRepository<FoodCart,Integer> {
    
	@Query("SELECT fc FROM FoodCart fc Inner Join fc.customer c where c.customerId=?1")
	public FoodCart findByCustomerId(Integer customerId );
	
	@Query("SELECT i FROM FoodCart fc INNER JOIN fc.itemList i WHERE i.itemId =?1")
	public Item findByItemId(Integer itemId);
	
	@Query("select f.itemList from FoodCart f")
    public List<Item> getAllItemsfromFoodCart();
	
	
}

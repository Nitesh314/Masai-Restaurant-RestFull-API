package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {
	
	public Item findByItemName(String itemName);
	
	public Item findByCategory(String categoryName);

}

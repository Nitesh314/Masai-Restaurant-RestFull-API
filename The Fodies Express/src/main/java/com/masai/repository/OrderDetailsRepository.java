package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exception.RestaurantException;
import com.masai.models.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
	
	@Query("Select od From OrderDetails od INNER JOIN od.cart fc INNER JOIN fc.itemList i INNER JOIN i.restaurants r where r.restaurantId=?1")
	public List<OrderDetails> viewAllOrderByRestaurant(Integer restaurantId);
	
	@Query("Select od From OrderDetails od INNER JOIN od.cart fc INNER JOIN fc.customer r Where r.customerId=?1")
	public List<OrderDetails> viewAllOrderInCustomer(Integer customerId);
	

}

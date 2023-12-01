package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.models.Bill;

public interface BillRepository extends JpaRepository<Bill,Integer> {
      
	
	@Query("Select b from Bill b INNER JOIN b.order o where o.orderId=?1")
	public Bill getBillByOrderId(Integer orderId);
	
	@Query("SELECT b FROM Bill b INNER JOIN b.order o INNER JOIN o.cart fc INNER JOIN fc.customer c WHERE c.customerId=?1")
	public List<Bill> getAllBillsByCustomerId(Integer customerId);
	
	@Query("SELECT b FROM Bill b INNER JOIN b.order o INNER JOIN o.cart fc INNER JOIN fc.itemList i INNER JOIN i.restaurants r WHERE r.restaurantId=?1")
	public List<Bill> getAllBillsByRestaurantId(Integer restaurantId);
	
	
	
}

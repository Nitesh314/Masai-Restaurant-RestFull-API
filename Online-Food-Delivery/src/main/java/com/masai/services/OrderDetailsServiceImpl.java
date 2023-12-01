package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.FoodCartException;
import com.masai.exception.ItemException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.Customer;
import com.masai.models.FoodCart;
import com.masai.models.Item;
import com.masai.models.LoginSession;
import com.masai.models.OrderDetails;
import com.masai.models.Restaurant;
import com.masai.repository.CustomerRepository;
import com.masai.repository.FoodCartRepository;
import com.masai.repository.ItemRepository;
import com.masai.repository.LoginSessionRepository;
import com.masai.repository.OrderDetailsRepository;
import com.masai.repository.RestaurantRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;

	@Autowired
	private FoodCartRepository foodCartRepo;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepo;
	
	
	@Override
	public OrderDetails addOrder(String userName, Integer cartId) throws LoginSessionException, FoodCartException,CustomerException {
		
		LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name,use correct user name for login in account...");
		}else {
			
			Optional<FoodCart> presentCart= foodCartRepo.findById(cartId);
			
			if(presentCart.isPresent()) {
				
				if(presentCart.get().getCustomer().getCustomerId()==presentUser.getLoginId()) {
				
				 OrderDetails order=new OrderDetails();
				 
				 order.setOrderDate(LocalDateTime.now());
				 order.setOrderStatus("Placed");
				 order.setCart(presentCart.get());
				 
				 OrderDetails savedOrder= orderDetailsRepo.save(order);
				 
				 return savedOrder;
				}else {
					throw new CustomerException("Invalid customer...");
				}
				
			}else {
				throw new FoodCartException("Invalid cartId...");
			}
			
		}
	}
	
//**************************************************************************************************************	

	@Override
	public OrderDetails removeOrderDetails(String userName, Integer orderId)throws LoginSessionException, OrderException {
		
        LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name,use correct user name for login in account...");
		}else {
			
			Optional<OrderDetails> presentOrder= orderDetailsRepo.findById(orderId);
			
			if(presentOrder.isPresent()) {
				
				orderDetailsRepo.delete(presentOrder.get());
				
				if(presentOrder.isEmpty()) {
					throw new OrderException("No order details...");
				}else {
					return presentOrder.get();
				}
				
			}else {
				throw new OrderException("No order found by order id...");
			}
			
		}
		
	}

//****************************************************************************************************************************
	
	@Override
	public OrderDetails cancelOrder(String userName, Integer orderId) throws LoginSessionException, OrderException {
		
		LoginSession presentUser= loginSessionRepo.findByUserName(userName);
		
		if(presentUser==null) {
			throw new LoginSessionException("Invalid user name, use correct user name to login in account...");
		}else {
			
			Optional<OrderDetails> presentOrder= orderDetailsRepo.findById(orderId);
			
			if(presentOrder.isPresent()) {
				
				 presentOrder.get().setOrderStatus("Cancelled");
				
				 OrderDetails cancelledOrderEntity= orderDetailsRepo.save(presentOrder.get());
				 
				 return cancelledOrderEntity;
				
				
			}else {
				throw new OrderException("Invalid cart Id...");
			}
			
		}
		
	}
	

//*******************************************************************************************************************

@Override
public List<OrderDetails> viewAllOrdersByRestaurant(String restaurantUserName)throws RestaurantException,OrderException {
	
	LoginSession presentUser= loginSessionRepo.findByUserName(restaurantUserName);
	
	if(presentUser==null) {
		throw new RestaurantException("Invalid restaurant user name,use correct user name to login in account...");
	}else {
		
		List<OrderDetails> orderList= orderDetailsRepo.viewAllOrderByRestaurant(presentUser.getLoginId());
		
		if(orderList.isEmpty()) {
			throw new OrderException("No order found....");
		}else {
			return orderList;
		}
		
	}
	
}
//********************************************************************************************************************

@Override
public List<OrderDetails> viewAllOrderByCustomer(String customerUserName) throws CustomerException, OrderException {
	
    LoginSession presentUser= loginSessionRepo.findByUserName(customerUserName);
	
	if(presentUser==null) {
		throw new CustomerException("Invalid customer user name,use correct user name to login in account...");
	}else {
		
		List<OrderDetails> orderList= orderDetailsRepo.viewAllOrderInCustomer(presentUser.getLoginId());
		
		if(orderList.isEmpty()) {
			throw new OrderException("No order found....");
		}else {
			return orderList;
		}
		
	}

}




}

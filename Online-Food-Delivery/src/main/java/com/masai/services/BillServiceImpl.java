package com.masai.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.BillException;
import com.masai.exception.LoginSessionException;
import com.masai.exception.OrderException;
import com.masai.exception.RestaurantException;
import com.masai.models.Bill;
import com.masai.models.Item;
import com.masai.models.LoginSession;
import com.masai.models.OrderDetails;
import com.masai.repository.BillRepository;
import com.masai.repository.LoginSessionRepository;
import com.masai.repository.OrderDetailsRepository;


@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;
	
	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private OrderDetailsRepository orderRepo;
	
	
	

	@Override
	public Bill createBillByRestaurant(String userName, Integer orederId)throws BillException, LoginSessionException, RestaurantException, OrderException {
		//userName is restaurant userName;
		LoginSession presentRestaurant= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid restaurant user name...");
		}else { 
			
			List<OrderDetails> orderList= orderRepo.viewAllOrderByRestaurant(presentRestaurant.getLoginId());
		    
			if(orderList==null) {
				throw new OrderException("No order...");
			}else {
			
			Bill bill=new Bill();
			for(OrderDetails o:orderList) {
                 
				if(o.getOrderId()==orederId) {
					
					bill.setBillDate(o.getOrderDate());
					bill.setOrder(o);
	                o.setOrderStatus("completed");
					List<Item> item= o.getCart().getItemList();
					
					for(Item i:item) {
						bill.setTotalItem(i.getQuantity());
						bill.setTotalCost(i.getCost()*i.getQuantity());
					}
					billRepo.save(bill);
				}else {
					throw new OrderException("Invalid order id...");
				}
				
			}
			return bill;
			}
		}

	
	
	}

//***********************************************************************************************
	@Override
	public Bill viewBillByCustomer(String userName, Integer orderId)throws LoginSessionException, OrderException {
		
		LoginSession presentCustomer= loginSessionRepo.findByUserName(userName);
		
		if(presentCustomer==null) {
			throw new LoginSessionException("Invalid customer user name...");
		}else {
		     
			 Bill bill= billRepo.getBillByOrderId(orderId);
			 
			 
			
			 if(bill==null) {
				 throw new OrderException("Invalid order Id...");
			 }else{
				 bill.getOrder().setOrderStatus("completed");
				 return bill;
			 }
			 
		}
		
		
		
	}
//*************************************************************************************************
	@Override
	public List<Bill> viewAllBillsByCustomer(String userName) throws LoginSessionException,BillException {
		
		LoginSession presentCustomer= loginSessionRepo.findByUserName(userName);
		
		if(presentCustomer==null) {
			throw new LoginSessionException("Invalid customer user name...");
		}else {
			
			List<Bill> billList= billRepo.getAllBillsByCustomerId(presentCustomer.getLoginId());
			
			billList.forEach(b->{
				b.getOrder().setOrderStatus("completed");
			});
			
			if(billList.isEmpty()) {
				throw new BillException("Sorry ! No bill present...");
			}else {
				return billList;
			}
			
		}
		
	}
//************************************************************************************************
	@Override
	public List<Bill> viewAllBillsByRestaurant(String userName) throws LoginSessionException,BillException {
		
        LoginSession presentRestaurant= loginSessionRepo.findByUserName(userName);
		
		if(presentRestaurant==null) {
			throw new LoginSessionException("Invalid restaurant user name...");
		}else {
			
			List<Bill> billList= billRepo.getAllBillsByRestaurantId(presentRestaurant.getLoginId());
			
			billList.forEach(b->{
				b.getOrder().setOrderStatus("completed");
			});
			
			if(billList.isEmpty()) {
				throw new BillException("Sorry ! No bill present...");
			}else {
				return billList;
			}
			
		}

		
	}

}

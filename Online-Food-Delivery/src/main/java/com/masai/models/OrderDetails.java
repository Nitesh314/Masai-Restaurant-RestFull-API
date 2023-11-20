package com.masai.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
	
	@Id
	private Integer orderId;
	private LocalDateTime orderDate;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private FoodCart cart;
	
	private String orderStatus;

}

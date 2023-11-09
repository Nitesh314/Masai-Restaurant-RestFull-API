package com.masai.models;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@OneToOne(targetEntity =Customer.class,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(targetEntity = Item.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Item>itemList;
	
}

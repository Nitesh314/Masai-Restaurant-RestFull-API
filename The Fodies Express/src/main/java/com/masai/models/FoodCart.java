package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	@OneToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	private List<Item> itemList=new ArrayList<>();

}

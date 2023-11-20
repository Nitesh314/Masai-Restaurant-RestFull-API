package com.masai.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	private Integer itemId;
	private String itemName;
	private Integer quantity;
	private Double cost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Restaurant> restaurants;
	

}

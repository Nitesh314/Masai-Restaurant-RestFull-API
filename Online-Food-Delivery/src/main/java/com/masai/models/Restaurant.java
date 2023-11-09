package com.masai.models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	@Pattern(regexp ="^[A-Za-z ]{2,30}$",message = "restaurant name contain only alphabetical characters and the length should be between 1 to 31 characters")
	private String restaurantName;
	@Pattern(regexp ="^[A-Za-z ]{2,15}$",message = "manager name contain only alphabetical characters and the length should be between 1 to 16 characters")
	private String managerName;
	@Pattern(regexp = "^\\+91[789]\\d{9}$",message = "mobile number should be start +91 code and first number should be eather 7,8 or 9 and it should be only 10 digit...")
	private String contactNumber;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(targetEntity = Item.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "restaurants")
	private List<Item> itemList;

}

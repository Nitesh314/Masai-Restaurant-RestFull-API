package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@NotBlank
	@NotEmpty
	@NotNull
	private String restaurantName;
	@NotBlank
	@NotEmpty
	@NotNull
	private String managerName;
	@NotBlank
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number pattern")
	private String mobileNumber;
	@NotBlank
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Invalid password! Password must be at least 8 characters long and include a mix of letters, numbers, and special characters")
	private String password;
	
	
	@Embedded
	private Address Address;
	
   
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Item> itemList=new ArrayList<>();

}

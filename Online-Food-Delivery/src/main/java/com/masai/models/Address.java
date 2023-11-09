package com.masai.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String buildingName;
	@Pattern(regexp ="^[2-9]\\d{3}$",message ="Street number should be start from 2 to 9 number and the length should be only 4 digit number...")
	private Integer streetNo;
	@Pattern(regexp ="^[A-Za-z ]+$",message = "Area names contain only alphabetical characters...")
	private String areaName;
	@Pattern(regexp ="^[A-Za-z ]+$",message = "City names contain only alphabetical characters...")
	private String cityName;
	private String country;
	@Pattern(regexp = "^[1-9]\\{5}$",message = "Pincode start 1 to 9 number and the length should be only 6 digit number...")
	private String pincode;
	
}

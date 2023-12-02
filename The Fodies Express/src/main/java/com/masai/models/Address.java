package com.masai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	public Integer addressId;
	private String buildingName;
	private String streetNo;
	private String areaName;
	private String city;
	private String state;
	private String country;
	private String pincode;
	

}

package com.masai.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginSession {
    
	@Id
	@Column(unique = true)
	private Integer loginId;//userId of customer or restaurant
	private String userName;//UserName is customer firstName; 
	private String mobileNumber;
	private String password;
	
	
	

}

package com.masai.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Size(min =2, max =15, message = "Name must be between 2 and 15 characters")
	private String firstName;
	@Size(min =2, max =15, message = "Name must be between 2 and 15 characters")
	private String lastName;
    @Min(value = 15, message = "Age must be 15 or older")
	@Max(value =  100, message = "Age must be 100 or younger")
	private Integer age;
    @Pattern(regexp = "^(male|female|transgender)$", message = "Invalid gender. Accepted values are male, female, or transgender.")
	private String gender;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number pattern")
	private String mobileNumber;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Invalid password! Password must be at least 8 characters long and include a mix of letters, numbers, and special characters")
	private String password;
	
	@Embedded
	private Address address;

}

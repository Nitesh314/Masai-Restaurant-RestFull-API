package com.masai.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer customerId;
	@Pattern(regexp ="^[A-Za-z ]{2,15}$",message = "name contain only alphabetical characters and the length should be between 1 to 16 characters")
	private String firstName;
	@Pattern(regexp ="^[A-Za-z ]{2,15}$",message = "name contain only alphabetical characters and the length should be between 1 to 16 characters")
	private String lastName;
	@Pattern(regexp = "^(1[5-9]|[2-9][0-9]|100)$",message = "age should be allow only greater than equal to 15 and less than equal to 100")
	private Integer age;
	@Pattern(regexp = "^(male|female|transgender)$",message = "gender should be allowed only male,female or transgender...")
	private String gender;
	@Pattern(regexp = "^\\+91[789]\\d{9}$",message = "mobile number should be start +91 code and first number should be eather 7,8 or 9 and it should be only 10 digit...")
	private String mobileNumber;
	@Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+$",message = "email should be follows this pattern abc124@gmail.com...")
	private String email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,15}$",message = "Password length is between 7 to 16 characters and it is follow the (Java@314) pattern here the specific symbole @#$%^&+=))")
	private String password;
	
	@OneToOne(targetEntity = Address.class ,cascade = CascadeType.ALL)
	private Address address;
	
	
	
	

}

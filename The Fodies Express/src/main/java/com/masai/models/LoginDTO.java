package com.masai.models;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number pattern")
	private String mobileNumber;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Invalid password! Password must be at least 8 characters long and include a mix of letters, numbers, and special characters")
	private String password;

}

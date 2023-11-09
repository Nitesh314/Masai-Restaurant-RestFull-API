package com.masai.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	@Id
	@Column(unique =true)
	private Integer userId;
	
	private String uuId;
	
	private String password;
	
	private LocalDateTime timeStamp;

}

package com.masai.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrors {
	
	private String msg;
	private String details;
	private LocalDateTime timeStamp;

}

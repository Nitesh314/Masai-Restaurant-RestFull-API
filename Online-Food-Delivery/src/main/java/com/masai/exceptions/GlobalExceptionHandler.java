package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrors>handleCustomerException(CustomerException ce,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(ce.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrors>handleAddressException(AddressException ae,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(ae.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrors>handleRestaurantException(RestaurantException re,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(re.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(FoodCartException.class)
	public ResponseEntity<MyErrors>handleFoodCartException(FoodCartException fe,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(fe.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrors>handleItemException(ItemException ie,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(ie.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrors>handleCategoryException(CategoryException cate,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(cate.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrors>handleLoginException(LoginException le,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(le.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrors>handleBillException(BillException be,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(be.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrors>handleOrderException(OrderException oe,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg(oe.getMessage());
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrors>handleNoHandlerFoundExc(NoHandlerFoundException ne,WebRequest weq){
       
		MyErrors err=new MyErrors();
		err.setMsg("Validation Exception");
		err.setDetails(weq.getDescription(false));
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrors>handleMethodArgumentNotValidationExc(MethodArgumentNotValidException me){
       
		MyErrors err=new MyErrors();
		err.setMsg("Resource not found");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		err.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
}

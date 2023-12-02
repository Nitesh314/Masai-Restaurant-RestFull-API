package com.masai.services;



import com.masai.exception.LoginSessionException;


import com.masai.models.LoginDTO;

public interface LoginSessionService {
	
	public String customerLogin(LoginDTO lDto)throws LoginSessionException;
	
	public String customerLogOut(String userName)throws LoginSessionException ;
	
    public String RestaturanLogin(LoginDTO lDto)throws LoginSessionException;
	
	public String RestaturantLogOut(String userName)throws LoginSessionException ;
	

}

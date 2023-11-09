package com.masai.services;

import com.masai.exceptions.LoginException;
import com.masai.models.LoginDTO;

public interface LoginService {
	
	//here it will return userName
	public String loginInToAccount(LoginDTO lDto)throws LoginException;
	
	//using this userName we logOut;
	public String logOutFromAccount(String uuId)throws LoginException;

}

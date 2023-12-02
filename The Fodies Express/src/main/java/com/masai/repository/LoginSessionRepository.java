package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.models.LoginSession;

public interface LoginSessionRepository extends JpaRepository<LoginSession,Integer> {
    
	public LoginSession findByUserName(String userName);
	
}

package com.masai.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
	
	
	public Login findByUuId(String uuId);
	
	

}

package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.AdminRepo;

@Repository
public class AdminLoginDao {

	@Autowired
	AdminRepo arepo;
	
	public boolean validateAd(User user){
		
		System.out.println(user);
		
		String adminPass = "amadmin";
		
		if(user.getPassword().equals(adminPass)) {
			return true;
		}
		else {
			return false;
		}
	}
}

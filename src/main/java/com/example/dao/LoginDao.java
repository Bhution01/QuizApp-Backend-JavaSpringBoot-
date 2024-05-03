package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.UserRepo;

@Repository
public class LoginDao {

	@Autowired
	UserRepo userrepo;
	
	public String validateUserr(String username) {
		System.out.println(username);
		User user = userrepo.findByUsername(username);
		System.out.println(user);
		if(user==null) {
			System.out.println("okokokokokokokokokokokook");
			return null;
		}
		else 
			return user.getPassword();
	}
	
	
}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.entity.User;

@Service
public class LoginService {
	
	@Autowired
	LoginDao dao;

	public Boolean sendToDao(User user) {
		String dbPass = dao.validateUserr(user.getUsername());
		
		if(dbPass==null) {
			return null;
		}
		else if(dbPass.equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UsernameVerify;
import com.example.entity.User;
import com.example.repository.UserRepo;

@RestController
public class UniqueUsernameController {
	
	@Autowired
	UsernameVerify Uvery;
	
	public List<User> allUsers() {
		List<User> userListt= Uvery.getAllUsernames();
		return userListt;
	}
}

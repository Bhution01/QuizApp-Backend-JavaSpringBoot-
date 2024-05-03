package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.UserRepo;

@Repository
public class UsernameVerify {

	@Autowired
	UserRepo repo;
	
	public List<User> getAllUsernames() {
		List<User> userList= repo.findAll();
		return userList;
	}
}

package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Question;
import com.example.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

	public User findByUsername(String username);
	
	public List<User> findAll(); 
}

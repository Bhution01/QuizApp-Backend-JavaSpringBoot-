package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.AdminLoginDao;
import com.example.entity.User;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminLogin {
	
	@Autowired
	AdminLoginDao aldao;

	@PostMapping("validateAdmin")
	public ResponseEntity<Boolean> validateAdmin(@RequestBody User user) {
	   
		boolean answer = aldao.validateAd(user);
		
		if(answer) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
}

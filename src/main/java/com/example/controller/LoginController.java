package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepo;
import com.example.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

	@Autowired
	UserRepo userrepo;
	
	@Autowired
	LoginService service;
	
	static HttpSession httpSession;
	
	@PostMapping("/validateUser")
	public ResponseEntity<Boolean> validateUser(@RequestBody User user, HttpServletRequest request) {
		Boolean answer = service.sendToDao(user);
		
		if(answer) {
			
			httpSession = request.getSession();
			
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
	}
}

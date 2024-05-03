package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Question;
import com.example.repository.AdminRepo;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminRepo arepo;
	
	@PostMapping("QuestionAdd")
	public void queAdd(@RequestBody Question question) {
		
		System.out.println(question);
		
		arepo.save(question);
		
	}

}

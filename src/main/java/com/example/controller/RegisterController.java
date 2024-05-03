package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepo;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterController {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	UniqueUsernameController uniqueUsername;
	
	@PostMapping("/saveUserr")
	public ResponseEntity<Boolean> saveUser(@RequestBody User user) {
		
	  List<User> userListtt = uniqueUsername.allUsers();
	  Boolean uniqueUser = null;
	  
	  for(User userl : userListtt) {
		  if(userl.getUsername().equals(user.getUsername())) {
			  uniqueUser=false;
			  break;
		  }else {
			  userrepo.save(user);
			   
			  uniqueUser = true;
		  }
		  
//		  System.out.println(uniqueUser);
	  }
		
	  if(uniqueUser) {
		  return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	  }
	  else {
		  return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	  }
	}

}

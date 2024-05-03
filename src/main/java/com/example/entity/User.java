package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	String username;
	String password;
	long mobno;
	String emailid;
	
	public User() {
		super();
		
	}

	public User(String username, String password, long mobno, String emailid) {
		super();
		this.username = username;
		this.password = password;
		this.mobno = mobno;
		this.emailid = emailid;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", mobno=" + mobno + ", emailid=" + emailid
				+ "]";
	}
	
	
	
}

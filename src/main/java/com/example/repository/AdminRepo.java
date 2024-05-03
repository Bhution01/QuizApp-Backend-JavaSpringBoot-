package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Question;

public interface AdminRepo extends JpaRepository<Question, Integer>{

}

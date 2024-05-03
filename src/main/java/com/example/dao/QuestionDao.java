package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Question;
import com.example.repository.QuestionRepo;

@Repository
public class QuestionDao {

	@Autowired
	QuestionRepo repo;
	
	public List<Question> getQue(String subject) {
		List<Question> ques = (List<Question>) repo.findBySubject(subject);
		System.out.println(subject);
		return ques;
	}
}

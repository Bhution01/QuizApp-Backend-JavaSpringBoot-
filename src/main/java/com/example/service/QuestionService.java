package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.QuestionDao;
import com.example.entity.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao dao;
	
	public List<Question> aa(String subject) {
		return dao.getQue(subject);
	}
}

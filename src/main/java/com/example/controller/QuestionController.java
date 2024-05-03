package com.example.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Answer;
import com.example.entity.Question;
import com.example.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	
	@GetMapping("getQuestion/{subject}")
	public ResponseEntity<Question> getQuestion(@PathVariable String subject) {
		System.out.println(subject);
		
		HttpSession httpsession = LoginController.httpSession;
		List<Question> quelist = service.aa(subject);
	    HashMap<Integer, Answer> hm = new HashMap<Integer,Answer>();
//		System.out.println(quelist);
		
		httpsession.setAttribute("que", quelist);
		httpsession.setAttribute("qnono", 0);
		httpsession.setAttribute("hashm", hm);
		httpsession.setAttribute("score", 0);
		
		Question question = quelist.get(0);
		
		return new ResponseEntity<Question>(question, HttpStatus.CREATED);
	}
	
	
	@GetMapping("nextQuestion")
	public ResponseEntity<Question> nextQuestion() {
		
		HttpSession session = LoginController.httpSession;
		
		List<Question> quelist = (List<Question>) session.getAttribute("que");
		System.out.println("okhe"+quelist);
		Question question;
		
		if((int)session.getAttribute("qnono")<=quelist.size()-2) {
			session.setAttribute("qnono", (int)session.getAttribute("qnono")+1);
			
			question = quelist.get((int) session.getAttribute("qnono"));
		}
		else {
			question = quelist.get(quelist.size()-1);
		}
		                                              
		return new ResponseEntity<Question>(question, HttpStatus.CREATED);
		
	}
	
	@GetMapping("previousQue")
	public ResponseEntity<Question> previousQuestion() {
		
		HttpSession session = LoginController.httpSession;
		
		List<Question> quelist = (List<Question>) session.getAttribute("que");
		
		Question question;
		
		if((int)session.getAttribute("qnono")>0) {
		  session.setAttribute("qnono", (int)session.getAttribute("qnono")-1);
		  
		  question = quelist.get((int)session.getAttribute("qnono"));
		}
		
		else {
			question = quelist.get(0);
		}
		
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	
	
	@GetMapping("endExam")
	public ResponseEntity<Integer> endExam() {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		HttpSession session = LoginController.httpSession;
		HashMap<Integer,Answer> hm = (HashMap<Integer, Answer>) session.getAttribute("hashm");
		Set<Entry<Integer, Answer>> setOfAns = hm.entrySet();
		
		for(Entry<Integer,Answer> ss : setOfAns) {
			Answer ans = ss.getValue();
			if(ans.getAnswer().equals(ans.getSubmitted())) {
				session.setAttribute("score", (int)session.getAttribute("score")+1);
			}
			
			
		}
		int score = (int) session.getAttribute("score");
		return new ResponseEntity<Integer>(score, HttpStatus.OK);	    
		
	}
	
	@PostMapping("submitAns")
	public void submitAns(@RequestBody Answer answer) {
		System.out.println("*************************************************************************");
		
	  HttpSession session = LoginController.httpSession;
	  HashMap<Integer,Answer> hm = (HashMap<Integer, Answer>) session.getAttribute("hashm");
	  hm.put(answer.getQno(), answer);
//	  System.out.println(hm);
//	  
//	  if(answer.getAnswer().equals(answer.getSubmitted())) {
//		  score++;
//	  }
//	  System.out.println(score);	
	}
	
	
	@GetMapping("getAllAns")
	public ResponseEntity<Collection<Answer>> getAllAns() {
	 
		HttpSession session = LoginController.httpSession;
	    HashMap<Integer,Answer> hm = (HashMap<Integer, Answer>) session.getAttribute("hashm");
		
	    Collection<Answer> cl = hm.values();
	    
	    return new ResponseEntity<Collection<Answer>>(cl, HttpStatus.OK);
	    
	    
	}
}




















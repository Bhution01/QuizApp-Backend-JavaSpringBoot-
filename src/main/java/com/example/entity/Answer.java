package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Answer {

	@Id
	public int qno;
	public String qtext;
	public String answer;
	public String submitted;
	
	
	
	public int getQno() {
		return qno;
	}



	public void setQno(int qno) {
		this.qno = qno;
	}



	public String getQtext() {
		return qtext;
	}



	public void setQtext(String qtext) {
		this.qtext = qtext;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getSubmitted() {
		return submitted;
	}



	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}



	@Override
	public String toString() {
		return "Answer [qno=" + qno + ", qtext=" + qtext + ", answer=" + answer + ", submitted=" + submitted + "]";
	}
	
	
}

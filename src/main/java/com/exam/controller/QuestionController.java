package com.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;



@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
   
	
	@GetMapping("/")
    public ResponseEntity<?> questions(){
    	return ResponseEntity.ok(this.questionService.getQuestions());
    }
	
	@GetMapping("/{qId}")
    public Question quize(@PathVariable Long qId){
    	
    	return this.questionService.getQuestion(qId);
	}
	
	
	
	@GetMapping("/quiz/{qId}")
    public ResponseEntity<?> quizeby(@PathVariable Long qId){
		

		
		Quiz quiz=this.quizService.getQuiz(qId);
		Set<Question> questions=quiz.getQuestions();
		List list=new ArrayList<>(questions);
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
		};
		
		Collections.shuffle(list);
		
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{qId}")
    public ResponseEntity<?> quizebyadmin(@PathVariable Long qId){
		

		
		Quiz quiz=new Quiz();
		quiz.setqId(qId);
		
		Set<Question> questions=this.questionService.getQuestionsOfQuiz(quiz);
	//	List list=new ArrayList<>(questions);
		
		
		
	//	Collections.shuffle(list);
		
		
		return ResponseEntity.ok(questions);
	}
	
	
	
}

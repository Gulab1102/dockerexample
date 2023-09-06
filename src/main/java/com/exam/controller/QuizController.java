package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addCategory(@RequestBody Quiz quiz){
		
		Quiz quiz1=this.quizService.addQuiz(quiz);
		
		return ResponseEntity.ok(quiz1);
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		
		Quiz quiz1=this.quizService.update(quiz);
		
		return ResponseEntity.ok(quiz1);
	}
	
    @GetMapping("/")
    public ResponseEntity<?> quizes(){
    	return ResponseEntity.ok(this.quizService.getQuizes());
    }
    
    @GetMapping("/{qId}")
    public Quiz quize(@PathVariable Long qId){
    	
    	return this.quizService.getQuiz(qId);
    }
    
    
    @DeleteMapping("/{qId}")
    public void delete(@PathVariable Long qId){
    	
    this.quizService.deleteQuiz(qId);
    }
    
    @GetMapping("/category/{cId}")
    public List<Quiz> quizBycategory(@PathVariable Long cId){
    	
    	Category category=new Category();
    	category.setCid(cId);
    	
    	return quizService.byCategory(category);
    	
    }
    
}

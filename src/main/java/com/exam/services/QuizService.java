package com.exam.services;

import java.util.List;
import java.util.Set;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

public interface QuizService {
	
public  Quiz addQuiz(Quiz quiz);
	
	public  Quiz update(Quiz quiz);
	
	public  Set<Quiz> getQuizes();
	
	public  Quiz getQuiz(Long qId);
	
	public  void deleteQuiz(Long qId);

	public List<Quiz> byCategory(Category category);

}

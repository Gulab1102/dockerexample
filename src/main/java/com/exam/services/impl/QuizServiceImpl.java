package com.exam.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepo;
import com.exam.services.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired 
	private QuizRepo quizRepo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz update(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		// TODO Auto-generated method stub
		return new HashSet<Quiz>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long qId) {
		// TODO Auto-generated method stub
		return this.quizRepo.findById(qId).get();
	}

	@Override
	public void deleteQuiz(Long qId) {
		// TODO Auto-generated method stub
		
		this.quizRepo.deleteById(qId);
		
	}

	@Override
	public List<Quiz> byCategory(Category category) {
		// TODO Auto-generated method stub
		return quizRepo.findByCategory(category);
	}

}

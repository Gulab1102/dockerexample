package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

	List<Quiz> findByCategory(Category category);

}

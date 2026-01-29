package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.repository.QuestionRepository;
import com.product.repository.QuizRepo;
import com.product.models.Question;
import com.product.models.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	QuestionRepository questionRepo;
	
	
	public ResponseEntity<String> createQuiz(String category, String title, int num) {
		Pageable pageable=Pageable.ofSize(num);
		List<Question> questions=questionRepo.createQuizWithRandomQues(category, pageable);
		Quiz q=new Quiz();
		q.setQuestions(questions);
		q.setTitle(title);
		quizRepo.save(q);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
}

package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.models.Question;
import com.product.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;

	public List<Question> getAllQuestions() {
		return questionRepo.findAll();
	}

	public List<Question> getQuestionByCategory(String category) {
		return questionRepo.findByCategory(category);
	}

	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}

}

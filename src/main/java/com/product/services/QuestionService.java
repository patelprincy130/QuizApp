package com.product.services;

import java.util.List;
import java.util.Optional;

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

	public void deleteQuestion(int id) {
		questionRepo.deleteById(id);
	}

	public Question updateTitle(int id, Question newQ) {
		Question question=questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found with id: "+id));
		question.setQuestionTitle(newQ.getQuestionTitle());
		question.setDifficultyLevel(newQ.getDifficultyLevel());
		question.setRightAnswer(newQ.getRightAnswer());
		questionRepo.save(question);
		return question;
	}

}

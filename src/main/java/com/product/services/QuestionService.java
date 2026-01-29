package com.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.models.Question;
import com.product.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepo;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.ACCEPTED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionRepo.save(question);
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Error adding new question",HttpStatus.BAD_REQUEST);
	}

	public void deleteQuestion(int id) {
		questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found with id: "+id));
		questionRepo.deleteById(id);
	}

	public ResponseEntity<Question> updateTitle(int id, Question newQ) {
		try {
			Question question=questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found with id: "+id));
			question.setQuestionTitle(newQ.getQuestionTitle());
			question.setDifficultyLevel(newQ.getDifficultyLevel());
			question.setRightAnswer(newQ.getRightAnswer());
			questionRepo.save(question);
			return new ResponseEntity<>(question,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
	}
	
//	public Question updateTitle(int id, Question newQ) {
//		Question question=questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found with id: "+id));
//		question.setQuestionTitle(newQ.getQuestionTitle());
//		question.setDifficultyLevel(newQ.getDifficultyLevel());
//		question.setRightAnswer(newQ.getRightAnswer());
//		questionRepo.save(question);
//		return question;
//	}

}

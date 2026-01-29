package com.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.models.Response;
import com.product.models.WrapperQuestion;
import com.product.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@PostMapping("/createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String title,
			@RequestParam int num) {
		return quizService.createQuiz(category, title, num);
	}
	
	@GetMapping("/getQuestions/{id}") //quiz id
	public ResponseEntity<List<WrapperQuestion>> getQuestionsById(@PathVariable int id){
		return quizService.getQuestionsById(id);
	}
	
	@GetMapping("/submit/{id}") //quiz id
	public ResponseEntity<Integer> getScore(@PathVariable int id,@RequestBody List<Response> response){
		return quizService.getScore(id,response);
	}
}

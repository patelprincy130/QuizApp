package com.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.models.Question;
import com.product.services.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("/allQuestions")
	@ResponseBody
	public List<Question> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@ResponseBody
	@GetMapping("/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	@ResponseBody
	@PostMapping("/addQuestion")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
}

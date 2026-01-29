package com.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.repository.QuestionRepository;
import com.product.repository.QuizRepo;
import com.product.models.Question;
import com.product.models.Quiz;
import com.product.models.WrapperQuestion;

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


	public ResponseEntity<List<WrapperQuestion>> getQuestionsById(int id) {
		Optional<Quiz> questions=quizRepo.findById(id);

		List<Question> questionsFromDb=questions.get().getQuestions();
		List<WrapperQuestion> questionsForUser=new ArrayList<>();
		
		for(Question q:questionsFromDb) {
			WrapperQuestion wq=new WrapperQuestion(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(wq);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}
}

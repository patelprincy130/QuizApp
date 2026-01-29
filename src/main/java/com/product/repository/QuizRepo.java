package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.models.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer>{

	

}

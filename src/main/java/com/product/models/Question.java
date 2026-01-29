package com.product.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "question_title")
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	@Column(name = "right_answer")
	private String rightAnswer;
	private String category;
	@Column(name = "difficulty_level")
	private String difficultyLevel;
}

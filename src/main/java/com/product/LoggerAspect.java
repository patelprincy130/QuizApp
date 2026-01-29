package com.product;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger LOGGER=LoggerFactory.getLogger(LoggerAspect.class);

	@Before("execution(public * com.product.controllers.QuestionController.deleteQuestion(int))")
	public void printLogger() {
		LOGGER.info("before delete method called");
	}
	
	@AfterReturning("execution(public * com.product.controllers.QuestionController.deleteQuestion(int))")
	public void printLoggerAfter() {
		LOGGER.info("after delete method called without any issue");
	}
	
	
}

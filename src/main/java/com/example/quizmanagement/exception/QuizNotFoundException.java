package com.example.quizmanagement.exception;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(Long quizId) {
        super("Quiz not found with ID: " + quizId);
    }
}

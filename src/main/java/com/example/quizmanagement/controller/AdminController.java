package com.example.quizmanagement.controller;

import com.example.quizmanagement.model.Quiz;
import com.example.quizmanagement.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/createQuiz")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/getAllQuizzes")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
}

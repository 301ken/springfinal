package com.example.quizmanagement.controller;

import com.example.quizmanagement.model.Quiz;
import com.example.quizmanagement.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable Long quizId) {
        return quizService.getQuizById(quizId);
    }

    @GetMapping("/getAll")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
}

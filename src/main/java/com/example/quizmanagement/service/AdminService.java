package com.example.quizmanagement.service;

import com.example.quizmanagement.model.Quiz;
import com.example.quizmanagement.model.Question;
import com.example.quizmanagement.model.User;
import com.example.quizmanagement.repository.QuizRepository;
import com.example.quizmanagement.repository.UserRepository;
import com.example.quizmanagement.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;


    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }


    public Question addQuestionToQuiz(Long quizId, Question question) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            question.setQuiz(quiz.get());
            return questionRepository.save(question);
        } else {
            throw new IllegalArgumentException("Quiz not found with ID: " + quizId);
        }
    }



    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }


    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }



    public User updateUser(String username, User updatedUser) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with username: " + username);
        }
    }
}

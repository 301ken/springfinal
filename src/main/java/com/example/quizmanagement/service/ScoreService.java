package com.example.quizmanagement.service;

import com.example.quizmanagement.model.Score;
import com.example.quizmanagement.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public Score getScore(Long scoreId) {
        return scoreRepository.findById(scoreId).orElse(null);
    }
}

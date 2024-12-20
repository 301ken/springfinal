package com.example.quizmanagement.repository;

import com.example.quizmanagement.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}

package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

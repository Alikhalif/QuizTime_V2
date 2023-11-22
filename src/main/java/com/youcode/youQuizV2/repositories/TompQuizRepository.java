package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.TompQuiz;
import com.youcode.youQuizV2.tool.TempID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TompQuizRepository extends JpaRepository<TompQuiz, TempID> {
}

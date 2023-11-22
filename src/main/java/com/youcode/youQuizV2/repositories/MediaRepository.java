package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.Media;
import com.youcode.youQuizV2.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Integer> {
    Media findByQuestion(Question question);
}

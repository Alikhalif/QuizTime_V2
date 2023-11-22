package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}

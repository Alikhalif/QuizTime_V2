package com.youcode.youQuizV2.repositories;

import com.youcode.youQuizV2.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.StudentAnswar.StudentAnswarResponsDto;
import com.youcode.youQuizV2.dto.StudentAnswarDto;

import java.util.List;

public interface StudentAnswarService{
    StudentAnswarDto create(StudentAnswarDto studentAnswarDto);
    List<StudentAnswarResponsDto> getAllAnswarOfStudent(Long assign_id);
}

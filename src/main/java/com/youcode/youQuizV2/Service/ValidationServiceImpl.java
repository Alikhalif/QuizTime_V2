package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.StudentAnswar.ValidationResponceDto;
import com.youcode.youQuizV2.dto.ValidationDto;

import java.util.List;

public interface ValidationServiceImpl {
    ValidationDto create(ValidationDto validationDto);
    List<ValidationResponceDto> getAll();
}

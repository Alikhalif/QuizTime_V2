package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto create(QuestionDto questionDto);
    void delete(Long id);
    QuestionDto getOne(Long id);
    List<QuestionDto> getAll();
    QuestionDto update(Long id, QuestionDto questionDto);
}

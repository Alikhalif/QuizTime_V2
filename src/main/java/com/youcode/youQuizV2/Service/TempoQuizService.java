package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.TompQuizDto;

public interface TempoQuizService {
    TompQuizDto create(TompQuizDto tompQuizDto);
    void delete(Long quiz_id, Long question_id);
    TompQuizDto update(Long quiz_id, Long question_id, TompQuizDto tompQuizDto);
}

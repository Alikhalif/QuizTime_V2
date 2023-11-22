package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.AnswarDto;

import java.util.List;

public interface AnswarService {
    AnswarDto create(AnswarDto answarDto);
    List<AnswarDto> getAll();
    AnswarDto getOne(Long id);
    void delete(Long id);
    AnswarDto update(Long id, AnswarDto answarDto);
}

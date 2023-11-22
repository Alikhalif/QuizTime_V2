package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.AssignQuizDto;

import java.util.List;

public interface AssignQuizService {
    List<AssignQuizDto> create(List<AssignQuizDto> assignQuizDtos);
    void delete(Long id);
    List<AssignQuizDto> getAll();
    AssignQuizDto getOne(Long id);
    AssignQuizDto update(Long id, AssignQuizDto assignQuizDto);
}

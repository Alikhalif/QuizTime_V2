package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.Exception.EntityNotFoundException;
import com.youcode.youQuizV2.dto.LevelDto;

import java.util.List;

public interface LevelService {
    LevelDto create(LevelDto levelDto);
    List<LevelDto> getAll();
    LevelDto getOne(Long id) throws EntityNotFoundException;
    void delete(Long id) throws EntityNotFoundException;
    LevelDto update(Long id, LevelDto levelDto);
}

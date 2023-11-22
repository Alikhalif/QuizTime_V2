package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto create(SubjectDto subjectDto);
    void delete(Long id);
    SubjectDto getOne(Long id);
    List<SubjectDto> getAll();
}

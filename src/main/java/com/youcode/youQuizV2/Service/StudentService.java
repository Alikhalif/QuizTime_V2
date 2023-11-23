package com.youcode.youQuizV2.Service;

import com.youcode.youQuizV2.Exception.EntityNotFoundException;
import com.youcode.youQuizV2.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto create(StudentDto studentDto);
    List<StudentDto> getAll();
    StudentDto getOne(Long id);
    StudentDto update(Long id, StudentDto studentDto) throws EntityNotFoundException;
    void delete(Long id);
    List<StudentDto> findByLimit(int pageNbr);
}

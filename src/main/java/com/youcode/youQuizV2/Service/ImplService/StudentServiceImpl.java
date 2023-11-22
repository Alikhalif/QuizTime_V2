package com.youcode.youQuizV2.Service.ImplService;

import com.youcode.youQuizV2.Service.StudentService;
import com.youcode.youQuizV2.dto.StudentDto;
import com.youcode.youQuizV2.entities.Student;
import com.youcode.youQuizV2.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto create(StudentDto studentDto){
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll(){
        return Arrays.asList(modelMapper.map(studentRepository.findAll(), StudentDto[].class));

    }

    @Override
    public StudentDto getOne(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.map(student -> modelMapper.map(student, StudentDto.class)).orElse(null);
    }


    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("The student with id " + id + " is not found"));
        Student student = modelMapper.map(studentDto, Student.class);
        student.setId(existingStudent.getId());
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public void delete(Long id){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new javax.persistence.EntityNotFoundException("The student with id " + id + " is not found"));
        studentRepository.delete(existingStudent);
    }
}

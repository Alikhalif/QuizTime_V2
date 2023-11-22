package com.youcode.youQuizV2.ImplService;

import com.youcode.youQuizV2.Service.ImplService.ValidationService;
import com.youcode.youQuizV2.dto.ValidationDto;
import com.youcode.youQuizV2.entities.Answar;
import com.youcode.youQuizV2.entities.Question;
import com.youcode.youQuizV2.entities.Validation;
import com.youcode.youQuizV2.repositories.AnswarRepository;
import com.youcode.youQuizV2.repositories.QuestionRepository;
import com.youcode.youQuizV2.repositories.ValidationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {
    @Mock
    private ValidationRepository validationRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswarRepository answarRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ValidationService validationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateValidation() {
        // Create a ValidationDto for testing
        ValidationDto validationDto = new ValidationDto();
        validationDto.setPoints(2.0);
        validationDto.setCheckAnswar(true);
        validationDto.setQuestion_id(1L);
        validationDto.setAnswar_id(2L);

        // Create a Question for testing
        Question question = new Question();
        question.setId(1L);

        // Create an Answar for testing
        Answar answar = new Answar();
        answar.setId(2L);

        // Create a Validation entity for testing
        Validation validation = new Validation();
        validation.setId(3L);

        // Mock the behavior of the repositories
        given(questionRepository.findById(1L)).willReturn(Optional.of(question));
        given(answarRepository.findById(2L)).willReturn(Optional.of(answar));

        // Mock the behavior of the model mapper
        when(modelMapper.map(validationDto, Validation.class)).thenReturn(validation);

        // Perform the service method
        ValidationDto result = validationService.create(validationDto);

        // Verify the result
        assertEquals(3L, result.getId());
    }
}

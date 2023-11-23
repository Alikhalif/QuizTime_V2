package com.youcode.youQuizV2.ImplService;

import com.youcode.youQuizV2.Exception.EntityNotFoundException;
import com.youcode.youQuizV2.Service.ImplService.QuestionServiceImpl;
import com.youcode.youQuizV2.dto.LevelDto;
import com.youcode.youQuizV2.dto.QuestionDto;
import com.youcode.youQuizV2.dto.StudentAnswar.QuestionDtoResponse;
import com.youcode.youQuizV2.dto.SubjectDto;
import com.youcode.youQuizV2.entities.Level;
import com.youcode.youQuizV2.entities.Question;
import com.youcode.youQuizV2.entities.Subject;
import com.youcode.youQuizV2.enums.QuestionType;
import com.youcode.youQuizV2.repositories.LevelRepository;
import com.youcode.youQuizV2.repositories.QuestionRepository;
import com.youcode.youQuizV2.repositories.SubjectRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private LevelRepository levelRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private QuestionServiceImpl questionService;

    private Question question;

    private QuestionDto questionDto;

    private QuestionDtoResponse questionDtoResponse;

    private Level level;

    private LevelDto levelDto;

    private Subject subject;

    private SubjectDto subjectDto;

    private SubjectDto subjectDtoResponse;

    @BeforeEach
    public void setUp() {
        question = Question.builder()
                .id(1L)
                .questionText("question text")
                .type(QuestionType.SINGLE)
                .totalScore(100.00)
                .build();
        questionDto = new QuestionDto();
        questionDto.setId(1L);
        questionDto.setQuestionText("question dto text");
        questionDto.setType(QuestionType.SINGLE);
        questionDto.setTotalScore(100.00);

        questionDtoResponse = new QuestionDtoResponse();
        questionDtoResponse.setId(1L);
        questionDtoResponse.setQuestionText("question dto response text");
        questionDtoResponse.setQuestionType(QuestionType.SINGLE);
        questionDtoResponse.setTotalScore(100.00);

        level = Level.builder()
                .id(1L)
                .description("level description")
                .maxScore(30.00)
                .minScore(5.00)
                .build();

        levelDto = new LevelDto();
        levelDto.setId(1L);
        levelDto.setDescription("level dto description");
        levelDto.setMaxScore(30.00);
        levelDto.setMinScore(5.00);

        subject = Subject.builder()
                .id(1L)
                .title("subject title")
                .build();

        subjectDto = new SubjectDto();
        subjectDto.setId(1L);
        subjectDto.setTitle("subject dto title");

        List<SubjectDto> subjectDtoList = new ArrayList<>();
        subjectDtoList.add(subjectDto);

        subjectDtoResponse = new SubjectDto();
        subjectDtoResponse.setId(1L);
        subjectDtoResponse.setTitle("subject dto response title");
        //subjectDtoResponse.setParentId(subjectDtoList);
    }

    @DisplayName("Test create question method in a success scenario")
    @Test
    public void testSuccessCreate() {
        given(modelMapper.map(questionDto, Question.class)).willReturn(question);
        given(modelMapper.map(question, QuestionDto.class)).willReturn(questionDto);
        given(questionRepository.save(question)).willReturn(question);
        QuestionDto savedQuestion = questionService.create(questionDto);
        assertThat(savedQuestion).isNotNull();
    }




    @DisplayName("Test delete question method with valid ID")
    @Test
    public void testSuccessDelete() {
        Long questionID = 1L;
        given(questionRepository.findById(questionID)).willReturn(Optional.of(question));
        willDoNothing().given(questionRepository).delete(question);
        questionService.delete(questionID);
        verify(questionRepository, times(1)).delete(question);
    }



    //@Test
    public void testFilledGetAll() {
        Question question1 = Question.builder()
                .id(2L)
                .questionText("question text")
                .type(QuestionType.SINGLE)
                .totalScore(100.00)
                .build();
        given(questionRepository.findAll()).willReturn(List.of(question, question1));
        given(modelMapper.map(question, QuestionDtoResponse.class)).willReturn(questionDtoResponse);
        //List<QuestionDto> allQuestions = questionService.getAll();
        verify(questionRepository).findAll();

    }

    @DisplayName("Test update question method in a success scenario")
    @Test
    public void testSuccessUpdate() {
        Long questionID = 1L;
        given(questionRepository.findById(questionID)).willReturn(Optional.of(question));
        given(modelMapper.map(question, QuestionDto.class)).willReturn(questionDto);
        given(questionRepository.save(question)).willReturn(question);
        QuestionDto updatedQuestion = questionService.update(questionID, questionDto);
        assertThat(updatedQuestion).isNotNull();
    }





}

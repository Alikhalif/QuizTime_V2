package com.youcode.youQuizV2.dto.StudentAnswar;

import com.youcode.youQuizV2.dto.LevelDto;
import com.youcode.youQuizV2.dto.MediaDto;
import com.youcode.youQuizV2.dto.SubjectDto;
import com.youcode.youQuizV2.enums.QuestionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionDtoResponse {
    private Long id;
    @NotBlank(message = "question content should not be empty")
    private String questionText;
    @NotNull(message = "question type is required")
    private QuestionType questionType;
    @Min(value = 0, message = "total score can't be less than 0")
    private Double totalScore;
    private SubjectDto subject;
    private LevelDto level;
    private List<MediaDto> medias;
}

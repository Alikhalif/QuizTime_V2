package com.youcode.youQuizV2.dto.StudentAnswar;

import com.youcode.youQuizV2.dto.AnswarDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationResponceDto {
    private Long id;
    private QuestionDtoResponse question;
    private AnswarDto answar;
    private Double points;

}

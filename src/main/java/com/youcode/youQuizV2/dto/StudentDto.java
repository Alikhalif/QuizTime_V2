package com.youcode.youQuizV2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDto extends UserDto{
    private Long id;
    @NotNull(message = "date of inscription should not be empty")
    private LocalDate dateInscription;
}

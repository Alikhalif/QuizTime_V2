package com.youcode.youQuizV2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @NotBlank(message = "first name should not be empty")
    protected String firstName;
    @NotBlank(message = "last name should not be empty")
    protected String lastName;
    @NotNull(message = "birthdate should not be empty")
    protected LocalDate birthDate;
    @NotBlank(message = "address should not be empty")
    protected String address;
}
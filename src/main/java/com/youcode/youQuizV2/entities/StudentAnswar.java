package com.youcode.youQuizV2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentanswars")
public class StudentAnswar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_id")
    private AssignQuiz assignQuiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validation_id")
    private Validation validation;
}
 
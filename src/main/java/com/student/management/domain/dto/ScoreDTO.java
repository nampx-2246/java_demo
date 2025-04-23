package com.student.management.domain.dto;

import lombok.Data;

@Data
public class ScoreDTO {
    private Long studentId;
    private Long subjectId;
    private Double score;
}

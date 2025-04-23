package com.student.management.domain.dto;

import lombok.Data;

@Data
public class ScoreInfoDTO {
    private String studentName;
    private String subjectName;
    private Double score;

    public ScoreInfoDTO(String studentName, String subjectName, Double score) {
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.score = score;
    }
}

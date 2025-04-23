package com.student.management.domain.repository;

import com.student.management.domain.dto.ScoreInfoDTO;
import com.student.management.domain.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("SELECT new com.student.management.domain.dto.ScoreInfoDTO(s.student.name, s.subject.name, s.score) FROM Score s WHERE s.student.id = :studentId")
    List<ScoreInfoDTO> findScoresByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT new com.student.management.domain.dto.ScoreInfoDTO(s.student.name, s.subject.name, s.score) FROM Score s WHERE s.subject.id = :subjectId")
    List<ScoreInfoDTO> findScoresBySubjectId(@Param("subjectId") Long subjectId);
}

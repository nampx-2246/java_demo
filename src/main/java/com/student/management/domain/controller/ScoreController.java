package com.student.management.domain.controller;

import com.student.management.domain.dto.ScoreDTO;
import com.student.management.domain.dto.ScoreInfoDTO;
import com.student.management.domain.entity.Score;
import com.student.management.domain.entity.Student;
import com.student.management.domain.entity.Subject;
import com.student.management.domain.repository.ScoreRepository;
import com.student.management.domain.repository.StudentRepository;
import com.student.management.domain.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ScoreDTO request) {
        Optional<Student> studentOpt = studentRepository.findById(request.getStudentId());
        Optional<Subject> subjectOpt = subjectRepository.findById(request.getSubjectId());

        if (studentOpt.isEmpty() || subjectOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid student or subject ID");
        }

        Score score = new Score();
        score.setStudent(studentOpt.get());
        score.setSubject(subjectOpt.get());
        score.setScore(request.getScore());

        return ResponseEntity.ok(scoreRepository.save(score));
    }

    @GetMapping("/student/{studentId}")
    public List<ScoreInfoDTO> getScoresByStudent(@PathVariable Long studentId) {
        return scoreRepository.findScoresByStudentId(studentId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<ScoreInfoDTO> getScoresBySubject(@PathVariable Long subjectId) {
        return scoreRepository.findScoresBySubjectId(subjectId);
    }
}

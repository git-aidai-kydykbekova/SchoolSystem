package com.example.Software_P.service;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.entity.Mark;

import java.util.List;

public interface MarkService {
    void markStudent(Long studentId, Long teacherId, int mark);

    List<Mark> getStudentsMarks(Long studentId);

    void deleteMark(Long markId);

    void updateMark(Long markId, MarkDto markDto);

     List<Mark> getMarksForSemester(Long studentId, String subject);
}

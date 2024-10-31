package com.example.Software_P.service;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void fillForm(TeacherDto teacherDto);

    Teacher getTeacher(Long id);

    void update(Long id, TeacherDto teacherDto);

    void deleteTeacher(Long id);

    void markStudent(Long studentId, Long teacherId, int mark);

    List<Mark> getStudentsMarks(Long studentId);

    void deleteMark(Long markId);

    void updateMark(Long markId, MarkDto markDto);
}

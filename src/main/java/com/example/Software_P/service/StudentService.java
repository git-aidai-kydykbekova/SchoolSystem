package com.example.Software_P.service;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Student;

import java.util.List;

public interface StudentService {
    void fillForm( StudentDto studentDto);

    Student getStudent(Long id);

    void update(Long id, StudentDto studentDto);

    void deleteStudent(Long id);

    List<Mark> getStudentsMarksMath(Long id);

    List<Mark> getStudentsMarksRussian(Long id);

    List<Mark> getStudentsMarksArt(Long id);

    List<Mark> getStudentsMarksMusic(Long id);

    List<Mark> getStudentsMarksScience(Long id);

    List<Mark> getStudentsMarksEnglish(Long id);

    List<Mark> getStudentsMarksHistory(Long id);
}

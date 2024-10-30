package com.example.Software_P.service;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Student;

public interface StudentService {
    void fillForm( StudentDto studentDto);

    Student getStudent(Long id);

    void update(Long id, StudentDto studentDto);

    void deleteStudent(Long id);
}

package com.example.Software_P.service;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.entity.Teacher;

public interface TeacherService {

    void fillForm(TeacherDto teacherDto);

    Teacher getTeacher(Long id);

    void update(Long id, TeacherDto teacherDto);

    void deleteTeacher(Long id);
}

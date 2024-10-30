package com.example.Software_P.mapper;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto entityToDto(Student student) {
        return new StudentDto()
                .setEmail(student.getEmail())
                .setGrade(student.getGrade())
                .setName(student.getName())
                .setSurname(student.getSurname());

    }

}

package com.example.Software_P.mapper;

import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherDto entityToDto(Teacher teacher) {
        return new TeacherDto()
                .setEmail(teacher.getEmail())
                .setName(teacher.getName())
                .setSurname(teacher.getSurname())
                .setPhone(teacher.getPhone())
                .setSubject(teacher.getSubject());
    }
}

package com.example.Software_P.service.impl;


import com.example.Software_P.dto.TeacherDto;

import com.example.Software_P.entity.Teacher;

import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.TeacherRepository;
import com.example.Software_P.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;



    @Override
    public void fillForm(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhone(teacherDto.getPhone());
        teacher.setSubject(teacherDto.getSubject());
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    @Override
    public void update(Long id, TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Student is not founded"));
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhone(teacherDto.getPhone());
        teacher.setSubject(teacherDto.getSubject());
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }


}

package com.example.Software_P.service.impl;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Student;
import com.example.Software_P.entity.User;
import com.example.Software_P.repository.StudentRepository;
import com.example.Software_P.repository.UserRepository;
import com.example.Software_P.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    @Override
    public void fillForm( StudentDto studentDto) {
        //Optional <User> user = userRepository.findById(id);
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setGrade(studentDto.getGrade());
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    public void update(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setGrade(studentDto.getGrade());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

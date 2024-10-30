package com.example.Software_P.controller;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.mapper.StudentMapper;
import com.example.Software_P.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;


    @PostMapping("/create")
    public void fillForm( @RequestBody StudentDto studentDto) {
        studentService.fillForm( studentDto);
    }
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentMapper.entityToDto(studentService.getStudent(id));
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        studentService.update(id, studentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}

package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.mapper.StudentMapper;
import com.example.Software_P.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final MarkMapper markMapper;


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

    @GetMapping("/mark/Math/{id}")
    public List<MarkDtoRequest> getMark(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksMath(id));
    }
    @GetMapping("/mark/Russian/{id}")
    public List<MarkDtoRequest> getMarkRussian(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksRussian(id));
    }
    @GetMapping("/mark/Art/{id}")
    public List<MarkDtoRequest> getMarkArt(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksArt(id));
    }
    @GetMapping("/mark/Music/{id}")
    public List<MarkDtoRequest> getMarkMusic(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksMusic(id));
    }
    @GetMapping("/mark/Science/{id}")
    public List<MarkDtoRequest> getMarkScience(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksScience(id));
    }
    @GetMapping("/mark/English/{id}")
    public List<MarkDtoRequest> getMarkEnglish(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksEnglish(id));
    }
    @GetMapping("/mark/History/{id}")
    public List<MarkDtoRequest> getMarkHistory(@PathVariable Long id) {
        return markMapper.entitytoDtoList(studentService.getStudentsMarksHistory(id));
    }
}

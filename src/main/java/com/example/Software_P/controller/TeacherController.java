package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.mapper.TeacherMapper;
import com.example.Software_P.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;


    @PostMapping("/create")
    public void fillForm( @RequestBody TeacherDto teacherDto) {
        teacherService.fillForm( teacherDto);
    }
    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) {
        return teacherMapper.entityToDto(teacherService.getTeacher(id));
    }
    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        teacherService.update(id, teacherDto);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }








}

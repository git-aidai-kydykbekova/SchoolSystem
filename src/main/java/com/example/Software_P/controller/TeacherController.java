package com.example.Software_P.controller;

import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.mapper.TeacherMapper;
import com.example.Software_P.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
@Slf4j
@Tag(name = "Teacher", description = "Operations related to teacher management")
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @Operation(
            summary = "Create a teacher",
            description = "Fill the form to create a new teacher."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Teacher created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/create")
    public void fillForm(@RequestBody TeacherDto teacherDto) {
        log.info("[#fillForm] is calling with teacherDto: {}", teacherDto);
        teacherService.fillForm(teacherDto);
    }

    @Operation(
            summary = "Get teacher by ID",
            description = "Retrieve teacher details by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Teacher retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Teacher not found")
    })
    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) {
        log.info("[#getTeacherById] is calling with id: {}", id);
        return teacherMapper.entityToDto(teacherService.getTeacher(id));
    }

    @Operation(
            summary = "Update teacher",
            description = "Update the details of an existing teacher by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Teacher updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Teacher not found")
    })
    @PutMapping("/{id}")
    public void updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        log.info("[#updateTeacher] is calling with id: {}, teacherDto: {}", id, teacherDto);
        teacherService.update(id, teacherDto);
    }

    @Operation(
            summary = "Delete teacher",
            description = "Delete a teacher by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Teacher deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Teacher not found")
    })
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        log.info("[#deleteTeacher] is calling with id: {}", id);
        teacherService.deleteTeacher(id);
    }
}

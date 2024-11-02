package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.mapper.StudentMapper;
import com.example.Software_P.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Slf4j
@Tag(name = "Student", description = "Operations related to student management")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final MarkMapper markMapper;

    @Operation(
            summary = "Create a student",
            description = "Fill the form to create a new student."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/create")
    public void fillForm(@RequestBody StudentDto studentDto) {
        log.info("[#fillForm] is calling with studentDto: {}", studentDto);
        studentService.fillForm(studentDto);
    }

    @Operation(
            summary = "Get student by ID",
            description = "Retrieve student details by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        log.info("[#getStudentById] is calling with id: {}", id);
        return studentMapper.entityToDto(studentService.getStudent(id));
    }

    @Operation(
            summary = "Update student",
            description = "Update the details of an existing student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        log.info("[#updateStudent] is calling with id: {}, studentDto: {}", id, studentDto);
        studentService.update(id, studentDto);
    }

    @Operation(
            summary = "Delete student",
            description = "Delete a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        log.info("[#deleteStudent] is calling with id: {}", id);
        studentService.deleteStudent(id);
    }

    @Operation(
            summary = "Get Math marks",
            description = "Retrieve Math marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/Math/{id}")
    public List<MarkDtoRequest> getMark(@PathVariable Long id) {
        log.info("[#getMark] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksMath(id));
    }

    @Operation(
            summary = "Get Russian marks",
            description = "Retrieve Russian marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/Russian/{id}")
    public List<MarkDtoRequest> getMarkRussian(@PathVariable Long id) {
        log.info("[#getMarkRussian] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksRussian(id));
    }

    @Operation(
            summary = "Get Art marks",
            description = "Retrieve Art marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/Art/{id}")
    public List<MarkDtoRequest> getMarkArt(@PathVariable Long id) {
        log.info("[#getMarkArt] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksArt(id));
    }

    @Operation(
            summary = "Get Music marks",
            description = "Retrieve Music marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/Music/{id}")
    public List<MarkDtoRequest> getMarkMusic(@PathVariable Long id) {
        log.info("[#getMarkMusic] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksMusic(id));
    }

    @Operation(
            summary = "Get Science marks",
            description = "Retrieve Science marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/Science/{id}")
    public List<MarkDtoRequest> getMarkScience(@PathVariable Long id) {
        log.info("[#getMarkScience] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksScience(id));
    }

    @Operation(
            summary = "Get English marks",
            description = "Retrieve English marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/English/{id}")
    public List<MarkDtoRequest> getMarkEnglish(@PathVariable Long id) {
        log.info("[#getMarkEnglish] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksEnglish(id));
    }

    @Operation(
            summary = "Get History marks",
            description = "Retrieve History marks for a student by their ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/mark/History/{id}")
    public List<MarkDtoRequest> getMarkHistory(@PathVariable Long id) {
        log.info("[#getMarkHistory] is calling with id: {}", id);
        return markMapper.entitytoDtoList(studentService.getStudentsMarksHistory(id));
    }
}

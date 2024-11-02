package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.service.MarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@AllArgsConstructor
@Slf4j
@Tag(name = "Mark", description = "Operations related to marks management")
public class MarkController {

    private final MarkMapper markMapper;
    private final MarkService markService;

    @Operation(
            summary = "Mark a student",
            description = "Assign a mark to a student by a teacher."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mark assigned successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Student or Teacher not found")
    })
    @PostMapping("/{studentId}/{teacherId}")
    public void markStudent(@RequestParam int mark, @PathVariable Long studentId, @PathVariable Long teacherId) {
        log.info("[#markStudent] is calling with studentId: {}, teacherId: {}, mark: {}", studentId, teacherId, mark);
        markService.markStudent(studentId, teacherId, mark);
    }

    @Operation(
            summary = "Get student's marks",
            description = "Retrieve all marks for a student."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{studentId}")
    public List<MarkDtoRequest> getMark(@PathVariable Long studentId) {
        log.info("[#getMark] is calling with studentId: {}", studentId);
        return markMapper.entitytoDtoList(markService.getStudentsMarks(studentId));
    }

    @Operation(
            summary = "Delete a mark",
            description = "Delete a mark by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mark deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Mark not found")
    })
    @DeleteMapping("/{markId}")
    public void deleteMark(@PathVariable Long markId) {
        log.info("[#deleteMark] is calling with markId: {}", markId);
        markService.deleteMark(markId);
    }

    @Operation(
            summary = "Update a mark",
            description = "Update a mark by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mark updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Mark not found")
    })
    @PutMapping("/{markId}")
    public void updateMark(@PathVariable Long markId, @RequestBody MarkDto markDto) {
        log.info("[#updateMark] is calling with markId: {}, markDto: {}", markId, markDto);
        markService.updateMark(markId, markDto);
    }

    @Operation(
            summary = "Get marks for a semester",
            description = "Retrieve all marks for a student in a specific subject for the semester."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marks retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student or Subject not found")
    })
    @GetMapping("/semester/{studentId}/")
    public List<MarkDtoRequest> getSemestersMark(@PathVariable Long studentId, @RequestParam String subject) {
        log.info("[#getSemestersMark] is calling with studentId: {}, subject: {}", studentId, subject);
        return markMapper.entitytoDtoList(markService.getMarksForSemester(studentId, subject));
    }
}

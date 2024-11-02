package com.example.Software_P.controller;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.mapper.HomeworkMapper;
import com.example.Software_P.service.HomeworkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hw")
@AllArgsConstructor
@Slf4j
@Tag(name = "Homework", description = "Operations related to homework management")
public class HomeworkController {

    private final HomeworkService homeworkService;
    private final HomeworkMapper homeworkMapper;

    @Operation(
            summary = "Create homework",
            description = "Create a new homework assigned by a teacher."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Homework created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Teacher not found")
    })
    @PostMapping("/{teacherId}")
    public void createHW(@PathVariable Long teacherId, @RequestBody HomeworkDto homeworkDto) {
        log.info("[#createHW] is calling with teacherId: {} and homeworkDto: {}", teacherId, homeworkDto);
        homeworkService.createHW(teacherId, homeworkDto);
    }

    @Operation(
            summary = "Get homework",
            description = "Retrieve homework details by homework ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Homework retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Homework not found")
    })
    @GetMapping("/{hwId}")
    public HomeworkDto getHomework(@PathVariable Long hwId) {
        log.info("[#getHomework] is calling with hwId: {}", hwId);
        return homeworkMapper.entityToDto(homeworkService.getHwById(hwId));
    }

}

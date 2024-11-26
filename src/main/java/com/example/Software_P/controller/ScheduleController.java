package com.example.Software_P.controller;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.mapper.ScheduleMapper;
import com.example.Software_P.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @PostMapping("/create")
    @Operation(summary = "Create a new schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created schedule"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public void createSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.createSchedule(scheduleDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a schedule by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved schedule", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Schedule not found", content = @Content)
    })
    public ScheduleDto getSchedule(@PathVariable Long id) {
        return scheduleMapper.entityToDto(scheduleService.getSchedule(id));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update an existing schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated schedule"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Schedule not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public void updateSchedule(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) {
        scheduleService.updateSchedule(scheduleDto, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a schedule by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted schedule"),
            @ApiResponse(responseCode = "404", description = "Schedule not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    @GetMapping("/byGrade")
    @Operation(summary = "Get schedules by grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved schedules", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Schedules not found", content = @Content)
    })
    public List<ScheduleDto> getScheduleByGrade(@RequestParam String grade) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByGrade(grade));
    }

    @GetMapping("/byDay")
    @Operation(summary = "Get schedules by day")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved schedules", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Schedules not found", content = @Content)
    })
    public List<ScheduleDto> getScheduleByDay(@RequestParam String day) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByDay(day));
    }

    @GetMapping("/byDayAndGrade")
    @Operation(summary = "Get schedules by day and grade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved schedules", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ScheduleDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Schedules not found", content = @Content)
    })
    public List<ScheduleDto> getScheduleByDayAndGrade(@RequestParam String day, @RequestParam String grade) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByDayAndGrade(day, grade));
    }
}

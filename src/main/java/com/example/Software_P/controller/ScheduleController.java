package com.example.Software_P.controller;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.mapper.ScheduleMapper;
import com.example.Software_P.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper scheduleMapper;

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.createSchedule(scheduleDto);
    }

    @GetMapping("/{id}")
    public ScheduleDto getSchedule(@PathVariable Long id) {
        return scheduleMapper.entityToDto(scheduleService.getSchedule(id));
    }

    @PutMapping("/update/{if}")
    public void updateSchedule(@RequestBody ScheduleDto scheduleDto, @PathVariable Long id) {
        scheduleService.updateSchedule(scheduleDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }
}

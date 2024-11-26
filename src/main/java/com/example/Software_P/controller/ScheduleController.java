package com.example.Software_P.controller;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.mapper.ScheduleMapper;
import com.example.Software_P.service.ScheduleService;
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

    @GetMapping("/byGrade")
    public List<ScheduleDto> getScheduleByGrade(@RequestParam String grade) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByGrade(grade));
    }

    @GetMapping("/byDay")
    public List<ScheduleDto> getScheduleByDay(@RequestParam String day) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByDay(day));
    }

    @GetMapping("/byDayAndGrade")
    public List<ScheduleDto> getScheduleByDayAndGrade(@RequestParam String day, @RequestParam String grade) {
        return scheduleMapper.entitytoDtoList(scheduleService.getListOfScheduleByDayAndGrade(day, grade));
    }


}

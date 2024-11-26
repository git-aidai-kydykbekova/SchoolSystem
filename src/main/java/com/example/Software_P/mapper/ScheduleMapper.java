package com.example.Software_P.mapper;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Homework;
import com.example.Software_P.entity.Schedule;
import com.example.Software_P.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleMapper {
    public ScheduleDto entityToDto(Schedule schedule) {
        return new ScheduleDto()
                .setDayOfWeek(schedule.getDayOfWeek())
                .setDueTime(schedule.getDueTime())
                .setTitle(schedule.getTitle())
                .setYear(schedule.getYear())
                .setGrade(schedule.getGrade());

    }

    public List<ScheduleDto> entitytoDtoList(List<Schedule> schedules) {
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleDtos.add(entityToDto(schedule));
        }
        return scheduleDtos;
    }
}

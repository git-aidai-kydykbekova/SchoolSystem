package com.example.Software_P.mapper;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Schedule;
import com.example.Software_P.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
    public ScheduleDto entityToDto(Schedule schedule) {
        return new ScheduleDto()
                .setDayOfWeek(schedule.getDayOfWeek())
                .setDueTime(schedule.getDueTime())
                .setTitle(schedule.getTitle())
                .setYear(schedule.getYear());

    }
}

package com.example.Software_P.service;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.entity.Schedule;

public interface ScheduleService {
    void createSchedule(ScheduleDto scheduleDto);

    Schedule getSchedule(Long id);

    void updateSchedule(ScheduleDto scheduleDto, Long id);

    void deleteSchedule(Long id);
}

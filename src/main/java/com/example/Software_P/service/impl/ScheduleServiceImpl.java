package com.example.Software_P.service.impl;

import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.entity.Schedule;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.ScheduleRepository;
import com.example.Software_P.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;


    @Override
    public void createSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setYear(scheduleDto.getYear());
        schedule.setTitle(scheduleDto.getTitle());
        schedule.setDueTime(scheduleDto.getDueTime());
        schedule.setDayOfWeek(scheduleDto.getDayOfWeek());

        scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Schedule not found"));
        return schedule;
    }

    @Override
    public void updateSchedule(ScheduleDto scheduleDto, Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Schedule not found"));

        schedule.setDayOfWeek(scheduleDto.getDayOfWeek());
        schedule.setTitle(scheduleDto.getTitle());
        schedule.setDueTime(scheduleDto.getDueTime());
        schedule.setYear(scheduleDto.getYear());

        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}

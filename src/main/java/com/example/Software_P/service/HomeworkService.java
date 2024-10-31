package com.example.Software_P.service;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.entity.Homework;

public interface HomeworkService {
    void createHW(Long teacherId, HomeworkDto homeworkDto);

    Homework getHwById(Long hwId);
}

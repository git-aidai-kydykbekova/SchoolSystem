package com.example.Software_P.controller;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.mapper.HomeworkMapper;
import com.example.Software_P.service.HomeworkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hw")
@AllArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;
    private final HomeworkMapper homeworkMapper;

    @PostMapping("/{teacherId}")
    public void createHW(@PathVariable Long teacherId, @RequestBody HomeworkDto homeworkDto) {
        homeworkService.createHW(teacherId, homeworkDto);
    }
    @GetMapping("/{hwId}")
    public HomeworkDto getHomework(@PathVariable Long hwId) {
        return homeworkMapper.entityToDto(homeworkService.getHwById(hwId));
    }

}

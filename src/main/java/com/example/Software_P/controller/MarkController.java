package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.service.MarkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
@AllArgsConstructor
public class MarkController {

    private final MarkMapper markMapper;
    private final MarkService markService;


    @PostMapping("/{studentId}/{teacherId}")
    public void markStudent(@RequestParam int mark, @PathVariable Long studentId, @PathVariable Long teacherId) {
        markService.markStudent(studentId, teacherId, mark);
    }
    @GetMapping("/{studentId}")
    public List<MarkDtoRequest> getMark(@PathVariable Long studentId) {
        return markMapper.entitytoDtoList(markService.getStudentsMarks(studentId));
    }
    @DeleteMapping("/{markId}")
    public void deleteMark(@PathVariable Long markId) {
        markService.deleteMark(markId);
    }
    @PutMapping("/{markId}")
    public void updateMark(@PathVariable Long markId, @RequestBody MarkDto markDto) {
        markService.updateMark(markId, markDto);
    }

    @GetMapping("/semester/{studentId}/")
    public void getSemestersMark(@PathVariable Long studentId, @RequestParam String subject) {
        markService.getMarksForSemester(studentId,subject);
    }
}

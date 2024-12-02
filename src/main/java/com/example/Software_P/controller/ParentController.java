package com.example.Software_P.controller;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.dto.ParentDTO;
import com.example.Software_P.mapper.MarkMapper;
import com.example.Software_P.service.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
@AllArgsConstructor
public class ParentController {


    private final ParentService parentService;
    private MarkMapper markMapper;

    @PostMapping("/create/{studentId}")
    public void createParent(@PathVariable Long studentId, @RequestBody ParentDTO parentDTO) {
        parentService.createParent(studentId,parentDTO);
    }

    @GetMapping("/getMark/{studentId}/{parentId}")
    public List<MarkDtoRequest> getMark(@PathVariable Long studentId, @PathVariable Long parentId) {
        return markMapper.entitytoDtoList(parentService.getMyChildsMark(studentId,parentId)) ;
    }
}

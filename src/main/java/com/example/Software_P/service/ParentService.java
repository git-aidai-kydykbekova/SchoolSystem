package com.example.Software_P.service;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.ParentDTO;
import com.example.Software_P.entity.Mark;

import java.util.List;

public interface ParentService {
    void createParent(Long studentId, ParentDTO parentDTO);

    List<Mark> getMyChildsMark(Long studentId, Long parentId);
}

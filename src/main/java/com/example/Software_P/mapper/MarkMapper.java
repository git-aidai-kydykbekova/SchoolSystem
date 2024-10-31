package com.example.Software_P.mapper;

import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.entity.Mark;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarkMapper {
    public MarkDtoRequest entityToDto(Mark mark) {
        return new MarkDtoRequest()
                .setMark(mark.getMark())
                .setSubject(mark.getSubject());
    }

    public List<MarkDtoRequest> entitytoDtoList(List<Mark> marks) {
        List<MarkDtoRequest> markDtos = new ArrayList<>();
        for (Mark mark : marks) {
            markDtos.add(entityToDto(mark));
        }
        return markDtos;
    }
}

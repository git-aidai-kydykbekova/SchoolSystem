package com.example.Software_P.mapper;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.dto.MarkDtoRequest;
import com.example.Software_P.entity.Homework;
import com.example.Software_P.entity.Mark;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HomeworkMapper {

    public HomeworkDto entityToDto(Homework homework) {
        return new HomeworkDto()
                .setDeadline(homework.getDeadline())
                .setDescription(homework.getDescription())
                .setGrade(homework.getGrade());
    }

    public List<HomeworkDto> entitytoDtoList(List<Homework> homeworks) {
        List<HomeworkDto> markDtos = new ArrayList<>();
        for (Homework homework : homeworks) {
            markDtos.add(entityToDto(homework));
        }
        return markDtos;
    }
}

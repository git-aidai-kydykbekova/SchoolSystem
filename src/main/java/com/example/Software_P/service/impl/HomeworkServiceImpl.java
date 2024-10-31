package com.example.Software_P.service.impl;

import com.example.Software_P.dto.HomeworkDto;
import com.example.Software_P.entity.Homework;
import com.example.Software_P.entity.Teacher;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.HomeworkRepository;
import com.example.Software_P.repository.TeacherRepository;
import com.example.Software_P.service.HomeworkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {
    private final TeacherRepository teacherRepository;
    private final HomeworkRepository homeworkRepository;
    @Override
    public void createHW(Long teacherId, HomeworkDto homeworkDto) {

        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new ObjectNotFoundException("teacher not founded"));
        Homework homework = new Homework();
        homework.setDeadline(homeworkDto.getDeadline());
        homework.setTeacher(teacher);
        homework.setDescription(homeworkDto.getDescription());
        homework.setSubject(teacher.getSubject());
        homework.setGrade(homeworkDto.getGrade());

        homeworkRepository.save(homework);

    }

    @Override
    public Homework getHwById(Long hwId) {
        return homeworkRepository.findById(hwId).orElseThrow(()-> new ObjectNotFoundException("hw not founded"));

    }
}

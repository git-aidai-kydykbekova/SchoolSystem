package com.example.Software_P.service.impl;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Student;
import com.example.Software_P.entity.Teacher;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.MarkRepository;
import com.example.Software_P.repository.StudentRepository;
import com.example.Software_P.repository.TeacherRepository;
import com.example.Software_P.service.MarkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MarkServiceImpl implements MarkService {

    private MarkRepository markRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Override
    public void markStudent(Long studentId, Long teacherId, int mark1) {
        Student student = studentRepository.findById(studentId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();


        Mark mark = new Mark();
        mark.setStudent(student);
        mark.setMark(mark1);
        mark.setSubject(teacher.getSubject());

        markRepository.save(mark);

        student.getMarks().add(mark);

    }

    @Override
    public List<Mark> getStudentsMarks(Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(()->new ObjectNotFoundException("Student is not founded"));
        List<Mark> marks = student.getMarks();
        return marks;
    }

    @Override
    public void deleteMark(Long markId) {
        markRepository.deleteById(markId);
    }

    @Override
    public void updateMark(Long markId, MarkDto markDto) {
        Mark mark = markRepository.findById(markId).orElseThrow(()->new ObjectNotFoundException("Mark is not founded"));
        mark.setMark(markDto.getMark());
        markRepository.save(mark);
    }

    @Override
    public void getMarksForSemester(Long studentId, String subject) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new ObjectNotFoundException("Student is not founded"));

    }
}

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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MarkServiceImpl implements MarkService {

    private MarkRepository markRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;


    @Override
    public void markStudent(Long studentId, Long teacherId, int mark1) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ObjectNotFoundException("Student not found"));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ObjectNotFoundException("Student not found"));


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
        return  student.getMarks();
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
    public List<Mark> getMarksForSemester(Long studentId, String subject) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ObjectNotFoundException("Student is not found"));

        LocalDate semesterStart = LocalDate.of(2024, 9, 1);
        LocalDate semesterEnd = LocalDate.of(2024, 12, 31);

        List<Mark> marks = student.getMarks();
        List<Mark> marksForSemester = new ArrayList<>();

        for (Mark mark : marks) {
            LocalDate markDate = mark.getCreationDate().toLocalDate(); // Преобразуем LocalDateTime в LocalDate
            if (markDate.isAfter(semesterStart.minusDays(1)) && markDate.isBefore(semesterEnd.plusDays(1)) && mark.getSubject().equals(subject)) {
                marksForSemester.add(mark);
            }
        }
        return marksForSemester;
    }

}

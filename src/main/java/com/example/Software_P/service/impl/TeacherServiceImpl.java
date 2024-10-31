package com.example.Software_P.service.impl;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.TeacherDto;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Student;
import com.example.Software_P.entity.Teacher;
import com.example.Software_P.repository.MarkRepository;
import com.example.Software_P.repository.StudentRepository;
import com.example.Software_P.repository.TeacherRepository;
import com.example.Software_P.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;


    @Override
    public void fillForm(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhone(teacherDto.getPhone());
        teacher.setSubject(teacherDto.getSubject());
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    @Override
    public void update(Long id, TeacherDto teacherDto) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        teacher.get().setName(teacherDto.getName());
        teacher.get().setSurname(teacherDto.getSurname());
        teacher.get().setEmail(teacherDto.getEmail());
        teacher.get().setPhone(teacherDto.getPhone());
        teacher.get().setSubject(teacherDto.getSubject());
        teacherRepository.save(teacher.get());
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void markStudent(Long studentId, Long teacherId, int mark1) {
        Student student = studentRepository.findById(studentId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();

        Mark mark = new Mark();
        mark.setStudent(student);
        mark.setTeacher(teacher);
        mark.setMark(mark1);
        mark.setSubject(teacher.getSubject());
        markRepository.save(mark);

        student.getMarks().add(mark);

    }

    @Override
    public List<Mark> getStudentsMarks(Long studentId) {

        Student student = studentRepository.findById(studentId).get();
        List<Mark> marks = student.getMarks();
        return marks;
    }

    @Override
    public void deleteMark(Long markId) {
        markRepository.deleteById(markId);
    }

    @Override
    public void updateMark(Long markId, MarkDto markDto) {
        Mark mark = markRepository.findById(markId).get();
        mark.setMark(markDto.getMark());
        markRepository.save(mark);
    }
}
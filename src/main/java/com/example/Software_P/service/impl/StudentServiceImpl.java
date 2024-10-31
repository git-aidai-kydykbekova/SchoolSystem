package com.example.Software_P.service.impl;

import com.example.Software_P.dto.StudentDto;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Student;
import com.example.Software_P.repository.StudentRepository;
import com.example.Software_P.repository.UserRepository;
import com.example.Software_P.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    @Override
    public void fillForm(StudentDto studentDto) {

        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setGrade(studentDto.getGrade());
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    public void update(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setGrade(studentDto.getGrade());
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Mark> getStudentsMarksMath(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksMath = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("MATH")){
                studentMarksMath.add(mark);
            }
        }

        return studentMarksMath;
    }

    @Override
    public List<Mark> getStudentsMarksRussian(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksRussian = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("RUSSIAN")){
                studentMarksRussian.add(mark);
            }
        }

        return studentMarksRussian;
    }

    @Override
    public List<Mark> getStudentsMarksArt(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksArt = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("ART")){
                studentMarksArt.add(mark);
            }
        }

        return studentMarksArt;
    }

    @Override
    public List<Mark> getStudentsMarksMusic(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksMusic = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("MUSIC")){
                studentMarksMusic.add(mark);
            }
        }

        return studentMarksMusic;
    }

    @Override
    public List<Mark> getStudentsMarksScience(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksScience = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("SCIENCE")){
                studentMarksScience.add(mark);
            }
        }

        return studentMarksScience;
    }

    @Override
    public List<Mark> getStudentsMarksEnglish(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksEnglish = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("ENGLISH")){
                studentMarksEnglish.add(mark);
            }
        }

        return studentMarksEnglish;
    }

    @Override
    public List<Mark> getStudentsMarksHistory(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Mark> studentMarks = student.getMarks();
        List<Mark> studentMarksHistory = new ArrayList<>();
        for(Mark mark : studentMarks){
            if(mark.getSubject().equals("HISTORY")){
                studentMarksHistory.add(mark);
            }
        }

        return studentMarksHistory;
    }
}

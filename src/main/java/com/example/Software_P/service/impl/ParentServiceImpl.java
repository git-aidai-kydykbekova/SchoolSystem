package com.example.Software_P.service.impl;

import com.example.Software_P.dto.MarkDto;
import com.example.Software_P.dto.ParentDTO;
import com.example.Software_P.entity.Mark;
import com.example.Software_P.entity.Parent;
import com.example.Software_P.entity.Student;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.MarkRepository;
import com.example.Software_P.repository.ParentRepository;
import com.example.Software_P.repository.StudentRepository;
import com.example.Software_P.service.MarkService;
import com.example.Software_P.service.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParentServiceImpl implements ParentService {

    private ParentRepository parentRepository;
    private StudentRepository studentRepository;
    private MarkService markService;
    @Override
    public void createParent(Long studentId, ParentDTO parentDTO) {
        Parent parent = new Parent();
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new ObjectNotFoundException("Student not found"));
        parent.setStudent(student);
        parent.setName(parentDTO.getName());
        parent.setSurname(parentDTO.getSurname());

        parentRepository.save(parent);
    }

    @Override
    public List<Mark> getMyChildsMark(Long studentId, Long parentId) {
        Parent parent = parentRepository.findById(parentId).orElseThrow(()-> new ObjectNotFoundException("Parent not found"));
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new ObjectNotFoundException("Student not found"));
        if (!parent.getStudent().getId().equals(studentId)) {
            throw new ObjectNotFoundException("Student does not belong to the specified parent");
        }

        if(parent.getStudent() == student){
            List<Mark> marks = markService.getStudentsMarks(studentId);
            return marks;
        }
        return null;
    }
}

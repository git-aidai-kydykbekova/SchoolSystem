package com.example.Software_P.service.impl;

import com.example.Software_P.entity.User;
import com.example.Software_P.enums.Role;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.UserRepository;
import com.example.Software_P.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public void changeRoleTeacher(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("User is not founded"));
        user.setRole(Role.TEACHER);
    }

    @Override
    public void changeRoleStudent(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("User is not founded"));
        user.setRole(Role.STUDENT);
    }
}

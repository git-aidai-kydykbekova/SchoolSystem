package com.example.Software_P.service.impl;

import com.example.Software_P.entity.User;
import com.example.Software_P.enums.Role;
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
        Optional<User> user = userRepository.findById(id);
        user.get().setRole(Role.TEACHER);
    }

    @Override
    public void changeRoleStudent(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.get().setRole(Role.STUDENT);
    }
}

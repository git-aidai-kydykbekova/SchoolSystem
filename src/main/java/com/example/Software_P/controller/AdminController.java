package com.example.Software_P.controller;

import com.example.Software_P.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("changeRoleTeacher/{id}")
    public void changeRoleTeacher(@PathVariable Long id){
        adminService.changeRoleTeacher(id);
    }

    @PostMapping("changeRoleStudent/{id}")
    public void changeRoleStudent(@PathVariable Long id){
        adminService.changeRoleStudent(id);
    }
}

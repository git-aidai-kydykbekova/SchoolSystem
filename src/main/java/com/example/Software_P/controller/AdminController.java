package com.example.Software_P.controller;

import com.example.Software_P.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
@Tag(name = "Admin", description = "Operations related to admin management")
public class AdminController {

    private final AdminService adminService;

    @Operation(
            summary = "Change role to teacher",
            description = "Change the role of a user to teacher."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role successfully changed"),
            @ApiResponse(responseCode = "400", description = "Invalid user ID"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("changeRoleTeacher/{id}")
    public void changeRoleTeacher(@PathVariable Long id) {
        log.info("[#changeRoleTeacher] is calling with ID: {}", id);
        adminService.changeRoleTeacher(id);
    }

    @Operation(
            summary = "Change role to student",
            description = "Change the role of a user to student."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role successfully changed"),
            @ApiResponse(responseCode = "400", description = "Invalid user ID"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("changeRoleStudent/{id}")
    public void changeRoleStudent(@PathVariable Long id) {
        log.info("[#changeRoleStudent] is calling with ID: {}", id);
        adminService.changeRoleStudent(id);
    }
}

package com.example.Software_P;

import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.UserRepository;
import com.example.Software_P.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AdminServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void changeRoleTeacher_UserNotFound_ThrowsObjectNotFoundException() {
        // Given
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When/Then
        assertThrows(ObjectNotFoundException.class, () -> adminService.changeRoleTeacher(1L));
        verify(userRepository, times(1)).findById(anyLong());
    }


    @Test
    void changeRoleStudent_UserNotFound_ThrowsObjectNotFoundException() {
        // Given
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When/Then
        assertThrows(ObjectNotFoundException.class, () -> adminService.changeRoleStudent(1L));
        verify(userRepository, times(1)).findById(anyLong());
    }
}

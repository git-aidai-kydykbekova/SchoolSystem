package com.example.Software_P.service;

import com.example.Software_P.entity.User;
public interface UserService {
    User create (User user);
    User getById(Long id);
    User getCurrentUser();
    String getMessage(Long userId);
}

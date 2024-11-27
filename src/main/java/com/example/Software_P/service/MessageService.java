package com.example.Software_P.service;

import com.example.Software_P.dto.MessageDto;
import com.example.Software_P.entity.Message;

public interface MessageService {
    void createMessage(MessageDto messageDto);

    Message getMessage(Long id);
}

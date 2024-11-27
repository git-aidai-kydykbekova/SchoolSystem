package com.example.Software_P.service.impl;

import com.example.Software_P.dto.MessageDto;
import com.example.Software_P.entity.Message;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.MessageRepository;
import com.example.Software_P.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    @Override
    public void createMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setTo(messageDto.getTo());
        message.setFrom(message.getFrom());
        message.setText(messageDto.getText());

        messageRepository.save(message);
    }

    @Override
    public Message getMessage(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("message not found"));
        return message;
    }
}

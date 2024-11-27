package com.example.Software_P.controller;

import com.example.Software_P.dto.MessageDto;
import com.example.Software_P.mapper.MessageMapper;
import com.example.Software_P.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @PostMapping("/create")
    public void createMessage(@RequestBody MessageDto messageDto) {
        messageService.createMessage(messageDto);
    }

    @GetMapping("/{id}")
    public MessageDto getMessage(@PathVariable Long id) {
        return messageMapper.entityToDto(messageService.getMessage(id));
    }
}

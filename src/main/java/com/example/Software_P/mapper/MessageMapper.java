package com.example.Software_P.mapper;

import com.example.Software_P.dto.MessageDto;
import com.example.Software_P.dto.ScheduleDto;
import com.example.Software_P.entity.Message;
import com.example.Software_P.entity.Schedule;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public MessageDto entityToDto(Message message) {
        return new MessageDto()
                .setFrom(message.getFrom())
                .setTo(message.getTo())
                .setText(message.getText());
    }
}

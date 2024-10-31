package com.example.Software_P.email;


import com.example.Software_P.dto.MailBody;

public interface EmailService {
    void sendSimpleMessage(MailBody mailBody);
}

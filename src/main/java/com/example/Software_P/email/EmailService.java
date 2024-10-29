package com.example.Software_P.email;


import com.example.Software_P.dto.MailBody;

public interface EmailService {
   // String sendSimpleMail(EmailDetails details);
   // String sendMailWithAttachment(EmailDetails details);
    void sendSimpleMessage(MailBody mailBody);
}

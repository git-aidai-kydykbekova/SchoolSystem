package com.example.Software_P.email;


import com.example.Software_P.dto.MailBody;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendSimpleMail(EmailDetails details) {
        log.info("[#sendSimpleMail] to: {}", details.getRecipient());

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMessageBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }


    public String sendMailWithAttachment(EmailDetails details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMessageBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        catch (MessagingException e) {

            return "Error while sending mail!!!";
        }
    }

    @Override
    public void sendSimpleMessage(MailBody mailBody) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mailBody.to());
        mailMessage.setFrom(sender);
        mailMessage.setSubject(mailBody.subject());
        mailMessage.setText(mailBody.body());

        javaMailSender.send(mailMessage);
    }
}

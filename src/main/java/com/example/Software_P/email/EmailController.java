package com.example.Software_P.email;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;


    // Sending a simple Email
//    @PostMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details) {
//        return emailService.sendSimpleMail(details);
//    }
//    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(@RequestBody EmailDetails details) {
//        return emailService.sendSimpleMail(details);
//    }
    //@PostMapping("/resetPassword")


}

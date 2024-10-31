package com.example.Software_P.controller;

import com.example.Software_P.dto.ChangePasswordDto;
import com.example.Software_P.dto.MailBody;
import com.example.Software_P.email.EmailService;
import com.example.Software_P.entity.ForgotPassword;
import com.example.Software_P.entity.User;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.ForgotPasswordRepository;
import com.example.Software_P.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class ForgotPasswordController {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/verifyMail")
    public ResponseEntity<String> verifyEmail(@RequestParam String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new ObjectNotFoundException("User not found"));

        int otp = otpGenerator();
        MailBody mailBody = MailBody.builder()
                .to(email)
                .body("This is OTP for your forgot password request: " + otp)
                .subject("OTP for your forgot password request")
                .build();

        ForgotPassword forgotPassword =
                ForgotPassword.builder()
                        .otp(otp)
                        .expirationTime(new Date(System.currentTimeMillis() + 70 * 100))
                        .user(user)
                        .build();

        emailService.sendSimpleMessage(mailBody);
        forgotPasswordRepository.save(forgotPassword);
        return ResponseEntity.ok("Email sent for verification successful");

    }

    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new ObjectNotFoundException("User not found"));
        ForgotPassword fp = forgotPasswordRepository.findOtpAndUser(otp, user).orElseThrow(()->new ObjectNotFoundException("Email not found"));
        Date now = Date.from(Instant.now());
        if (fp.getExpirationTime().before(now)) {
            forgotPasswordRepository.deleteById(fp.getFpid());
            return new ResponseEntity<>("OTP Expired ", HttpStatus.EXPECTATION_FAILED);
        }
        return ResponseEntity.ok("OTP verified successfully");

    }

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePassword(@PathVariable String email, @RequestBody ChangePasswordDto changePasswordDto) {

        if(!Objects.equals(changePasswordDto.password(), changePasswordDto.repeatPassword())) {
            return new ResponseEntity<>("Password does not match", HttpStatus.BAD_REQUEST);
        }

        String encodedPassword = passwordEncoder.encode(changePasswordDto.password());
        userRepository.updatePassword(email, encodedPassword);
        return ResponseEntity.ok("Password changed successfully");

    }

    private Integer otpGenerator() {
        Random random = new Random();
        return random.nextInt(100_000,999_999);
    }
}

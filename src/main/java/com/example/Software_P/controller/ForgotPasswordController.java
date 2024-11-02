package com.example.Software_P.controller;

import com.example.Software_P.dto.ChangePasswordDto;
import com.example.Software_P.dto.MailBody;
import com.example.Software_P.email.EmailService;
import com.example.Software_P.entity.ForgotPassword;
import com.example.Software_P.entity.User;
import com.example.Software_P.exception.ObjectNotFoundException;
import com.example.Software_P.repository.ForgotPasswordRepository;
import com.example.Software_P.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Tag(name = "ForgotPassword", description = "Operations related to forgot password functionality")
public class ForgotPasswordController {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final PasswordEncoder passwordEncoder;

    @Operation(
            summary = "Verify email",
            description = "Send an OTP to the user's email for password reset verification."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email sent for verification successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("/verifyMail")
    public ResponseEntity<String> verifyEmail(@RequestParam String email) {
        log.info("[#verifyEmail] is calling with email: {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

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

    @Operation(
            summary = "Verify OTP",
            description = "Verify the OTP sent to the user's email."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP verified successfully"),
            @ApiResponse(responseCode = "404", description = "User or OTP not found"),
            @ApiResponse(responseCode = "417", description = "OTP expired")
    })
    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp, @PathVariable String email) {
        log.info("[#verifyOtp] is calling with OTP: {} and email: {}", otp, email);

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("User not found"));
        ForgotPassword fp = forgotPasswordRepository.findOtpAndUser(otp, user).orElseThrow(() -> new ObjectNotFoundException("Email not found"));
        Date now = Date.from(Instant.now());
        if (fp.getExpirationTime().before(now)) {
            forgotPasswordRepository.deleteById(fp.getFpid());
            return new ResponseEntity<>("OTP Expired", HttpStatus.EXPECTATION_FAILED);
        }
        return ResponseEntity.ok("OTP verified successfully");
    }

    @Operation(
            summary = "Change password",
            description = "Change the user's password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password changed successfully"),
            @ApiResponse(responseCode = "400", description = "Password does not match"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> changePassword(@PathVariable String email, @RequestBody ChangePasswordDto changePasswordDto) {
        log.info("[#changePassword] is calling with email: {}", email);

        if (!Objects.equals(changePasswordDto.password(), changePasswordDto.repeatPassword())) {
            return new ResponseEntity<>("Password does not match", HttpStatus.BAD_REQUEST);
        }

        String encodedPassword = passwordEncoder.encode(changePasswordDto.password());
        userRepository.updatePassword(email, encodedPassword);
        return ResponseEntity.ok("Password changed successfully");
    }

    private Integer otpGenerator() {
        Random random = new Random();
        return random.nextInt(100_000, 999_999);
    }
}

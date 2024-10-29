package com.example.Software_P.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor

public class ForgotPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fpid;

    private Integer otp;

    private Date expirationTime;

    @OneToOne
    private User user;
    @PrePersist
    public void setExpirationTime() {
        this.expirationTime = Date.from(Instant.now().plus(6, ChronoUnit.MINUTES));
    }

    public Date getExpirationTime() {
        return expirationTime;
    }


}

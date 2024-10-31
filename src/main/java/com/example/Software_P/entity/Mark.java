package com.example.Software_P.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "marks")
@Getter
@Setter
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    private LocalDateTime creationDate;
    private String subject;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;




    @PrePersist
    private void prePersist() {
        creationDate = LocalDateTime.now();

    }
}

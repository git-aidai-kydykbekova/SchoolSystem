package com.example.Software_P.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "homeworks")
@Getter
@Setter

public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime dateTime;

    private OffsetDateTime deadline;
    private String subject;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @PrePersist
    public void prePersist() {
        dateTime = LocalDateTime.now();
    }

}

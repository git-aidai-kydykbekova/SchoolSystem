package com.example.Software_P.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String dayOfWeek;
    private String dueTime;
    private String year;
    private String grade;

}

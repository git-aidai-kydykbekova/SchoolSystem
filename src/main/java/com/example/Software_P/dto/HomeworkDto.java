package com.example.Software_P.dto;

import java.time.LocalDateTime;

public class HomeworkDto {
    private String grade;
    private String description;
    private LocalDateTime deadline;

    public String getGrade() {
        return grade;
    }

    public HomeworkDto setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public HomeworkDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public HomeworkDto setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
        return this;
    }
}

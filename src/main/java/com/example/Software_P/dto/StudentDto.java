package com.example.Software_P.dto;




public class StudentDto {
    private String name;
    private String surname;
    private String email;
    private String grade;

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public StudentDto setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}

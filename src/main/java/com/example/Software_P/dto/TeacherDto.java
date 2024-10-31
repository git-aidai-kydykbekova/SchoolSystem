package com.example.Software_P.dto;


public class TeacherDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String subject;

    public String getName() {
        return name;
    }

    public TeacherDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public TeacherDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TeacherDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TeacherDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public TeacherDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public TeacherDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}


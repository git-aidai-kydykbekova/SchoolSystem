package com.example.Software_P.dto;

public class MarkDtoRequest {
    private int mark;
    private String subject;

    public int getMark() {
        return mark;
    }

    public MarkDtoRequest setMark(int mark) {
        this.mark = mark;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MarkDtoRequest setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}

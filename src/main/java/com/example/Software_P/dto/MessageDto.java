package com.example.Software_P.dto;

public class MessageDto {

    private String to;
    private String from;

    private String text;

    public String getTo() {
        return to;
    }

    public MessageDto setTo(String to) {
        this.to = to;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public MessageDto setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getText() {
        return text;
    }

    public MessageDto setText(String text) {
        this.text = text;
        return this;
    }
}

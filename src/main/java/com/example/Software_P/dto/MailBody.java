package com.example.Software_P.dto;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String body) {
}

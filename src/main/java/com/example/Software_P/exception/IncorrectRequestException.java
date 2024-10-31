package com.example.Software_P.exception;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException(String parameter) {
        super("You need to provide " + parameter);
    }
}

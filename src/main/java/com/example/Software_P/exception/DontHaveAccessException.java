package com.example.Software_P.exception;

public class DontHaveAccessException extends RuntimeException{
    public DontHaveAccessException() {
        super("You cannot do that because you don't have access.");
    }
}

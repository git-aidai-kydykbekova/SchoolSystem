package com.example.Software_P.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objectName) {
        super(objectName + " is not found");
    }
}

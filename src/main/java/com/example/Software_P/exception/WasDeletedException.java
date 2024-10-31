package com.example.Software_P.exception;

public class WasDeletedException extends RuntimeException{
    public WasDeletedException(String objectName) {
        super("This " + objectName + " was deleted");
    }

}

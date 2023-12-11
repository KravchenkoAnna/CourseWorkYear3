package com.example.courseWork.courseWork.exception;

public class DetalNotFoundException extends IllegalArgumentException{
    public DetalNotFoundException(String message) {
        super(String.format("Detal with %s doesn't exist in the database", message));
    }
}

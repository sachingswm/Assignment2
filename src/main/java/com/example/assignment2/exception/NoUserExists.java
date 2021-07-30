package com.example.assignment2.exception;

public class NoUserExists extends Exception {
    private String message;
    public NoUserExists(String message)
    {
        super(message);
    }
}

package com.example.assignment2.exception;

public class UserInvalidDetails extends Exception {
    private String message;
    public UserInvalidDetails(String message) {
        super(message);
    }
}

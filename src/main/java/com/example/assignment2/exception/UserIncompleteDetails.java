package com.example.assignment2.exception;

public class UserIncompleteDetails extends Exception{
    private String message;

    public UserIncompleteDetails(String message) {
        super(message);

    }
}

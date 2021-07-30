package com.example.assignment2.exception;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}

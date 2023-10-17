package com.test.testopswat.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String error;
    private String message;
    private String service;
    private int statusCode;
    private LocalDateTime timestamp;
}

package com.test.testopswat.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setError("Exception exception");
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setService("Exception");
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setTimestamp(LocalDateTime.now());

        LOG.error("Exception: {} Message: {}", exception.getClass().getName(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ErrorResponse> handleJsonProcessingException(JsonProcessingException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setError("JsonProcessing threw an exception");
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setService("JsonProcessing");
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setTimestamp(LocalDateTime.now());

        LOG.error("Exception: {} Message: {}", exception.getClass().getName(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<ErrorResponse> handleHttpStatusExceptions(HttpStatusCodeException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setError("HttpStatus threw an exception");
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setService("HttpStatus");
        errorResponse.setStatusCode(exception.getRawStatusCode());
        errorResponse.setTimestamp(LocalDateTime.now());

        LOG.error("Exception: {} Message: {} StatusCode: {}", exception.getClass().getName(), exception.getMessage(), exception.getRawStatusCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

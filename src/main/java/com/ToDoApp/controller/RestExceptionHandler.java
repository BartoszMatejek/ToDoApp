package com.ToDoApp.controller;

import com.ToDoApp.exception.DataValidationException;
import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String bodyOfResponse = "This resource does not exist";
        LOGGER.info("Resource not found", ex);
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    protected ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException ex) {
        String bodyOfResponse = "Error when handling request";
        LOGGER.error("Internal Server Error", ex);
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = DataValidationException.class)
    protected ResponseEntity<String> handleDataValidationException(DataValidationException e) {
        String bodyOfResponse = e.getValidationMessage();
        LOGGER.info(e.getMessage(), e);
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }
}

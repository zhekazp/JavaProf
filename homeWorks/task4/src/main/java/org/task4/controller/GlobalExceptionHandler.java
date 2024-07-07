package org.task4.controller;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.task4.DTO.ResponseErrors;
import org.task4.exeption.NotFoundException;
import org.task4.exeption.NullArgException;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullArgException.class)
    public ResponseEntity<String> handlerNullArgException(NullArgException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException exception) {

        StringBuilder responseMessage = new StringBuilder();

        exception.getConstraintViolations()
                .forEach(constraintViolation -> {
                    String message = constraintViolation.getMessage();
                    responseMessage.append(message);
                    responseMessage.append("\n");
                });
        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseErrors>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<ResponseErrors> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ResponseErrors(error.getField(), error.getDefaultMessage()))
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

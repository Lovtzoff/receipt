package ru.clevertec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.ErrorMessage;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(ParameterNotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(ParameterNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }
}

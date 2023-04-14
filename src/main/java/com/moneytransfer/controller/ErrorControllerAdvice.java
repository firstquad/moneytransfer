package com.moneytransfer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Dmitrii Firstov 23/03/2023
 */
@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Throwable> unexpectedExceptionHandler(Exception e) {
        return ResponseEntity.status(500).body(new RuntimeException(e).getCause());
    }
}

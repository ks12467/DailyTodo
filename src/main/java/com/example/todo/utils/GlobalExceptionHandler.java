package com.example.todo.utils;

import com.example.todo.utils.apipayload.ApiResponse;
import com.example.todo.utils.apipayload.status.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(ErrorStatus._NOT_FOUND_USER.getStatus()).body(ApiResponse.fail(ErrorStatus._NOT_FOUND_USER));
    }
}

package com.example.todo.utils;

import com.example.todo.utils.apipayload.BaseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    private final BaseCode errorCode;
}

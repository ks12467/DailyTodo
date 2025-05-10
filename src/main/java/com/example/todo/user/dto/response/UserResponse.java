package com.example.todo.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponse {

    private final Long userId;
    private final String name;

}

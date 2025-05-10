package com.example.todo.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserUpdateResponse {

    private final Long userId;
    private final String name;
    private final String birth;
}

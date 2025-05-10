package com.example.todo.user.dto.response;

import com.example.todo.user.config.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDetailResponse {

    private final Long userId;
    private final String name;
    private final String birth;
    private final Gender gender;
}

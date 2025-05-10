package com.example.todo.user.dto.request;

import com.example.todo.user.config.Gender;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String name;
    private String birth;
    private Gender gender;
}

package com.example.todo.user.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UserUpdateReqeust {

    private String name;
    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;
}

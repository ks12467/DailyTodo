package com.example.todo.memo.dto.request;

import com.example.todo.user.entity.Users;
import lombok.Getter;

@Getter
public class MemoCreateRequest {

    private String title;
    private String content;
    private Users userId;
    private String password;


}

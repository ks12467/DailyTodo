package com.example.todo.memo.dto.response;

import com.example.todo.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoCreateResponse {

    private final long memoId;
    private final String title;
    private final String content;
    private final Users userId;
    private final String password;
}

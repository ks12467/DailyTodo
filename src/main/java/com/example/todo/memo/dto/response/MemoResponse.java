package com.example.todo.memo.dto.response;

import com.example.todo.user.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResponse {

    private final Long memoId;
    private final String title;
    private final Users userId;

}

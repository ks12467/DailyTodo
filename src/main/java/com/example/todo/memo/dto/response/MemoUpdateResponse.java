package com.example.todo.memo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoUpdateResponse {

    private final Long memoId;
    private final String title;
    private final String content;
}

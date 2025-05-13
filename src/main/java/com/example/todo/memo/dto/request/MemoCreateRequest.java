package com.example.todo.memo.dto.request;

import com.example.todo.user.entity.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemoCreateRequest {

    @NotBlank(message = "제목 입력은 필수입니다.")
    private String title;
    @Size(min = 10, max = 300, message = "10자 이상 300자 미만으로 입력해주세요" )
    private String content;
    @NotBlank(message = "사용자 아이디 번호를 입력하세요")
    private Users userId;
    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;


}

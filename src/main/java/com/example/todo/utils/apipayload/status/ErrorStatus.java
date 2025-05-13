package com.example.todo.utils.apipayload.status;

import com.example.todo.utils.apipayload.BaseCode;
import com.example.todo.utils.apipayload.dto.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    _NOT_FOUND_USER(HttpStatus.NOT_FOUND, "404", "해당 유저를 찾을 수 없습니다."),
    _NOT_FOUND_MEMO(HttpStatus.NOT_FOUND, "404", "해당 메모를 찾을 수 없습니다.");

    private HttpStatus httpStatus;
    private String statusCode;
    private String message;


    @Override
    public ReasonDto getResonHttpStatus() {
        return ReasonDto.builder()
                .statusCode(statusCode)
                .message(message)
                .httpStatus(httpStatus)
                .success(false)
                .build();
    }
}

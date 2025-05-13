package com.example.todo.utils.apipayload.status;

import com.example.todo.utils.apipayload.BaseCode;
import com.example.todo.utils.apipayload.dto.ReasonDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK, "200", "Ok");

    private final HttpStatus httpStatus;
    private final String statusCode;
    private final String message;

    @Override
    public ReasonDto getResonHttpStatus() {
        return ReasonDto.builder()
                .statusCode(statusCode)
                .message(message)
                .httpStatus(httpStatus)
                .success(true)
                .build();
    }
}

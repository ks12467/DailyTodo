package com.example.todo.auth.controller;

import com.example.todo.auth.dto.request.LoginRequest;
import com.example.todo.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/v1/auth")
    public ResponseEntity<String> loginUser(HttpServletRequest httpRequest, @Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.loginUser(httpRequest, loginRequest));
    }
}

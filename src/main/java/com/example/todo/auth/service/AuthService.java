package com.example.todo.auth.service;


import com.example.todo.auth.dto.request.LoginRequest;
import com.example.todo.user.entity.Users;
import com.example.todo.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String loginUser(HttpServletRequest httpRequest, LoginRequest loginRequest) throws Exception {
        Users user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("이메일 없음"));

        if(!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IllegalArgumentException("Password Error");
        }

        HttpSession session = httpRequest.getSession(true); // 세션이 없으면 생성
        session.setAttribute("loginUser", user.getEmail()); // 또는 user 객체 전체
        return "로그인 성공";
    }
}

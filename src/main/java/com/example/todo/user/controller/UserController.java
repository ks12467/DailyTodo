package com.example.todo.user.controller;

import com.example.todo.user.dto.request.CreateUserRequest;
import com.example.todo.user.dto.request.UserUpdateReqeust;
import com.example.todo.user.dto.response.CreateUserResponse;
import com.example.todo.user.dto.response.UserDetailResponse;
import com.example.todo.user.dto.response.UserResponse;
import com.example.todo.user.dto.response.UserUpdateResponse;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/v1")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @GetMapping("/v1")
    public ResponseEntity<List<UserResponse>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDetailResponse> findByIdUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findByIdUser(id));
    }

    @PutMapping("/v1/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable Long id, @RequestBody UserUpdateReqeust userUpdateReqeust) {
        return ResponseEntity.ok(userService.updateUser(id, userUpdateReqeust));
    }

    @DeleteMapping("/v1/{id}")
    public void deleteUser(@PathVariable Long id) {
        ResponseEntity.ok(userService.deleteUser(id));
    }
}

package com.example.todo.user.service;

import com.example.todo.user.dto.request.CreateUserRequest;
import com.example.todo.user.dto.request.UserUpdateReqeust;
import com.example.todo.user.dto.response.CreateUserResponse;
import com.example.todo.user.dto.response.UserDetailResponse;
import com.example.todo.user.dto.response.UserResponse;
import com.example.todo.user.dto.response.UserUpdateResponse;
import com.example.todo.user.entity.Users;
import com.example.todo.user.repository.UserRepository;
import com.example.todo.utils.ApiException;
import com.example.todo.utils.apipayload.status.ErrorStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        Users user = new Users(
                createUserRequest.getName(),
                createUserRequest.getEmail()
        );

        Users saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getEmail()
        );
    }

    public UserDetailResponse findByIdUser(Long id) {
        Users findUserId = userRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_USER)
        );
        return new UserDetailResponse(
                findUserId.getId(),
                findUserId.getName(),
                findUserId.getEmail()
        );
    }

    @Transactional
    public UserUpdateResponse updateUser(Long id, UserUpdateReqeust userUpdateReqeust) {
        Users findUserId = userRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_USER)
        );
        findUserId.update(userUpdateReqeust.getName(), userUpdateReqeust.getEmail());
        return new UserUpdateResponse(findUserId.getId(), findUserId.getName(), findUserId.getEmail());
    }


    public Void deleteUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_USER)
        );
        return null;
    }

    public Users findByIdUserRepo(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_USER)
        );
    }
}

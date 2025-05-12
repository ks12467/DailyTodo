package com.example.todo.user.service;

import com.example.todo.user.dto.request.CreateUserRequest;
import com.example.todo.user.dto.request.UserUpdateReqeust;
import com.example.todo.user.dto.response.CreateUserResponse;
import com.example.todo.user.dto.response.UserDetailResponse;
import com.example.todo.user.dto.response.UserResponse;
import com.example.todo.user.dto.response.UserUpdateResponse;
import com.example.todo.user.entity.Users;
import com.example.todo.user.repository.UserRepository;
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
                createUserRequest.getBirth(),
                createUserRequest.getGender()
        );

        Users saveUser = userRepository.save(user);
        return new CreateUserResponse(
                saveUser.getId(),
                saveUser.getName(),
                saveUser.getBirth(),
                saveUser.getGender());
    }

    public List<UserResponse> findAllUser() {
        List<Users> userList = userRepository.findAll();

        List<UserResponse> dtoList = new ArrayList<>();
        for (Users user : userList) {
            UserResponse dto = new UserResponse(user.getId(), user.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public UserDetailResponse findByIdUser(Long id) {
        Users findUserId = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User Not Found")
        );
        return new UserDetailResponse(
                findUserId.getId(),
                findUserId.getName(),
                findUserId.getBirth(),
                findUserId.getGender());
    }

    @Transactional
    public UserUpdateResponse updateUser(Long id, UserUpdateReqeust userUpdateReqeust) {
        Users findUserId = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User Not Found")
        );
        findUserId.update(userUpdateReqeust.getName(), userUpdateReqeust.getBirth());
        return new UserUpdateResponse(findUserId.getId(), findUserId.getName(), findUserId.getBirth());
    }


    public Void deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    public Users findByIdUserRepo(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
        );
    }
}

package com.example.todo.memo.controller;

import com.example.todo.memo.dto.request.MemoCreateRequest;
import com.example.todo.memo.dto.request.MemoUpdateRequest;
import com.example.todo.memo.dto.response.*;
import com.example.todo.memo.entity.Memo;
import com.example.todo.memo.service.MemoService;
import com.example.todo.user.entity.Users;
import com.example.todo.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemoController {

    private final MemoService memoService;
    private final UserService userService;

    @PostMapping("/v1/memo")
    public ResponseEntity<MemoCreateResponse> createMemo(@RequestBody @Valid MemoCreateRequest memoCreateRequest) {
        return ResponseEntity.ok(memoService.createMemo(memoCreateRequest));
    }

    @GetMapping("/v1/memo")
    public ResponseEntity<PageMemoResponse<MemoResponse>> pageMemo(Pageable pageable) {
        return ResponseEntity.ok(memoService.pageAllMemo(pageable));
    }

    @GetMapping("/v1/memo/{id}")
    public ResponseEntity<MemoDetailResponse> findByIdMemo(@PathVariable Long memoId) {
        return ResponseEntity.ok(memoService.findByIdMemo(memoId));
    }

    @PutMapping("/v1/memo/{id}")
    public ResponseEntity<MemoUpdateResponse> updateMemo(@PathVariable Long memoId, @RequestParam Long userId, @RequestParam String password, @RequestBody MemoUpdateRequest memoUpdateRequest) {
        return ResponseEntity.ok(memoService.updateMemo(memoId,userId,password,memoUpdateRequest));
    }

    @DeleteMapping("/v1/memo/{id}")
    public void deleteMemo(@PathVariable Long memoId, @RequestParam Long userId) {
        memoService.deleteMemo(memoId,userId);
    }
}

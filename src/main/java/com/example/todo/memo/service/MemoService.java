package com.example.todo.memo.service;

import com.example.todo.memo.dto.request.MemoCreateRequest;
import com.example.todo.memo.dto.request.MemoUpdateRequest;
import com.example.todo.memo.dto.response.*;
import com.example.todo.memo.entity.Memo;
import com.example.todo.memo.repository.MemoRepository;
import com.example.todo.utils.ApiException;
import com.example.todo.utils.apipayload.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;


    public MemoCreateResponse  createMemo(MemoCreateRequest memoCreateRequest) {
        Memo memo = new Memo(
                memoCreateRequest.getTitle(),
                memoCreateRequest.getContent(),
                memoCreateRequest.getUserId(),
                memoCreateRequest.getPassword()
        );
        Memo saveMemo = memoRepository.save(memo);
        return new MemoCreateResponse(
                saveMemo.getMemoId(),
                saveMemo.getTitle(),
                saveMemo.getContent(),
                saveMemo.getUserId(),
                saveMemo.getPassword());
    }



    public MemoDetailResponse findByIdMemo(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_MEMO)
        );

        MemoDetailResponse dto = new MemoDetailResponse(
                memo.getMemoId(),
                memo.getTitle(),
                memo.getContent(),
                memo.getUserId()
        );
        return dto;
    }

    public MemoUpdateResponse updateMemo(Long memoId, Long userId, String password, MemoUpdateRequest memoUpdateRequest) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_MEMO)
        );
        if(!memo.getUserId().equals(userId)) {
            throw new ApiException(ErrorStatus._NOT_FOUND_USER);
        }

        if(!memo.equals(password)) {
            throw new ApiException(ErrorStatus._VALID_FAIL);
        }

        memo.update(memoUpdateRequest.getTitle(), memoUpdateRequest.getContent());
        return new MemoUpdateResponse(memo.getMemoId(),memo.getTitle(),memo.getContent());
    }

    public void deleteMemo(Long memoId, Long userId) {
        Memo memo =memoRepository.findById(memoId).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_MEMO)
        );

        if(!memo.getUserId().equals(userId)) {
            throw new ApiException(ErrorStatus._NOT_FOUND_USER);
        } else {
            memoRepository.delete(memo);
        }
    }

    public PageMemoResponse<MemoResponse> pageAllMemo(Pageable pageable) {

        Page<Memo> memos = memoRepository.findAll(pageable);

        List<MemoResponse> content = memos.getContent().stream()
                .map(memo -> new MemoResponse(memo.getMemoId(),memo.getTitle(),memo.getUserId()))
                .toList();

        return new PageMemoResponse<>(
                content,
                memos.getNumber(),
                memos.getSize(),
                memos.getTotalElements(),
                memos.getTotalPages(),
                memos.isLast()
        );
    }
}

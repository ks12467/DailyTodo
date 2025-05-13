package com.example.todo.memo.service;

import com.example.todo.memo.dto.request.MemoCreateRequest;
import com.example.todo.memo.dto.request.MemoUpdateRequest;
import com.example.todo.memo.dto.response.MemoCreateResponse;
import com.example.todo.memo.dto.response.MemoDetailResponse;
import com.example.todo.memo.dto.response.MemoResponse;
import com.example.todo.memo.dto.response.MemoUpdateResponse;
import com.example.todo.memo.entity.Memo;
import com.example.todo.memo.repository.MemoRepository;
import com.example.todo.utils.ApiException;
import com.example.todo.utils.apipayload.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;


    public MemoCreateResponse createMemo(MemoCreateRequest memoCreateRequest) {
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

    public List<MemoResponse> findAllMemo() {
        List<Memo> memoList = memoRepository.findAll();

        List<MemoResponse> dtoList = new ArrayList<>();
        for (Memo memo : memoList) {
            MemoResponse dto = new MemoResponse(
                    memo.getMemoId(),
                    memo.getTitle(),
                    memo.getUserId()
            );
            dtoList.add(dto);
        }
        return dtoList;
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

    public MemoUpdateResponse updateMemo(Long memoId, Long userId, MemoUpdateRequest memoUpdateRequest) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new ApiException(ErrorStatus._NOT_FOUND_MEMO)
        );
        if(!memo.getUserId().equals(userId)) {
            throw new ApiException(ErrorStatus._NOT_FOUND_USER);
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
}

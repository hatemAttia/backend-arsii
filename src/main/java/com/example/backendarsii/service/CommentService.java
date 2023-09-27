package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.CommentRequest;
import com.example.backendarsii.dto.responseDto.CommentResponse;

import java.util.List;

public interface CommentService {
    void createComment(CommentRequest commentRequest);

    void deleteComment(Integer id);

    CommentResponse updateComment(Integer id, CommentRequest commentRequest);

    List<CommentResponse> getAllComment();
}

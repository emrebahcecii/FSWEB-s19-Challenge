package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.CommentPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentResponseDto;

public interface CommentService {

    CommentResponseDto create (CommentRequestDto commentRequestDto);
    CommentResponseDto update (Long id, CommentPatchRequestDto commentPatchRequestDto);
    void delete(Long id);
}

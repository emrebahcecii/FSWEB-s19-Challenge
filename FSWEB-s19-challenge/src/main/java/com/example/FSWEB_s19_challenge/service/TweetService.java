package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetResponseDto;

import java.util.List;

public interface TweetService {

    TweetResponseDto create(TweetRequestDto tweetRequestDto);
    List<TweetResponseDto> findByUserId(Long userId);
    TweetResponseDto findById(Long id);
    TweetResponseDto update(Long id, TweetPatchRequestDto tweetPatchRequestDto);
    void delete (Long id);


}

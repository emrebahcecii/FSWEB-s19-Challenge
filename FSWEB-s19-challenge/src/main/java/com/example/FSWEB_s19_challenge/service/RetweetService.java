package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.RetweetResponseDto;

public interface RetweetService {

    RetweetResponseDto retweet(String source);
    void delete(Long retweetId);
}

package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;

public interface LikeService {

    void like(Long tweetId, String mood);
    void disLike(Long tweetId);
}

package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.LikeRequestDto;
import com.example.FSWEB_s19_challenge.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping("/{tweetId}")
    public void like(@PathVariable Long tweetId, @RequestBody @Valid LikeRequestDto likeRequestDto) {
        likeService.like(tweetId, likeRequestDto.mood());
    }

    @PostMapping("/{tweetId}/dislike")
    public void disLike(@PathVariable Long tweetId) {
        likeService.disLike(tweetId);
    }


}

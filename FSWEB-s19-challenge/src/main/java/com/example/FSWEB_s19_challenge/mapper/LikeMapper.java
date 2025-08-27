package com.example.FSWEB_s19_challenge.mapper;

import com.example.FSWEB_s19_challenge.dto.LikePatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.LikeRequestDto;
import com.example.FSWEB_s19_challenge.dto.LikeResponseDto;
import com.example.FSWEB_s19_challenge.entity.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper {

    public Like toEntity(LikeRequestDto likeRequestDto){
        Like like = new Like();
        like.setMood(likeRequestDto.mood());
        return like;
    }
    public LikeResponseDto toResponseDto(Like like){
        return new LikeResponseDto(like.getMood());
    }

    public Like updateEntity(Like updateLike, LikePatchRequestDto likePatchRequestDto){
        if(likePatchRequestDto.mood() != null){
            updateLike.setMood(likePatchRequestDto.mood());
        }
        return updateLike;
    }
}

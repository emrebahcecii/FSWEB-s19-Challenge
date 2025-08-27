package com.example.FSWEB_s19_challenge.mapper;

import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetResponseDto;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    public Tweet toEntity(TweetRequestDto tweetRequestDto){
        Tweet tweet = new Tweet();
        tweet.setContent(tweetRequestDto.content());
        return tweet;
    }

    public TweetResponseDto toResponseDto(Tweet tweet){
        return new TweetResponseDto(tweet.getId(), tweet.getContent());
    }

    public Tweet updateEntity(Tweet updateToEntity, TweetPatchRequestDto tweetPatchRequestDto){
        if(tweetPatchRequestDto.content() != null){
            updateToEntity.setContent(tweetPatchRequestDto.content());
        }
        return updateToEntity;
    }
}

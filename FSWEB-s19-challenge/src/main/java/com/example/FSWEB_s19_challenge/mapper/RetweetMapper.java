package com.example.FSWEB_s19_challenge.mapper;

import com.example.FSWEB_s19_challenge.dto.RetweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.RetweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.RetweetResponseDto;
import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.entity.Retweet;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import org.springframework.stereotype.Component;

@Component
public class RetweetMapper {

    public Retweet toEntity(RetweetRequestDto retweetRequestDto){
        Retweet retweet = new Retweet();
        retweet.setSource(retweetRequestDto.source());
        return retweet;
    }
    public RetweetResponseDto toResponseDto(Retweet retweet){
        return new RetweetResponseDto(retweet.getSource());
    }

    public Retweet updateEntity(Retweet updateToEntity, RetweetPatchRequestDto retweetPatchRequestDto){
        if(retweetPatchRequestDto.source() != null){
            updateToEntity.setSource(retweetPatchRequestDto.source());
        }
        return updateToEntity;
    }
}

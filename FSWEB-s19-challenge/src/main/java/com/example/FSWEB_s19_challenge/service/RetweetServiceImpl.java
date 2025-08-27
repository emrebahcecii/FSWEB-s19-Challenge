package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.RetweetResponseDto;
import com.example.FSWEB_s19_challenge.entity.Retweet;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.exception.RetweetException;
import com.example.FSWEB_s19_challenge.mapper.RetweetMapper;
import com.example.FSWEB_s19_challenge.repository.RetweetRepository;
import com.example.FSWEB_s19_challenge.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetweetServiceImpl implements RetweetService {

    private RetweetRepository retweetRepository;
    private RetweetMapper retweetMapper;

    @Autowired
    public RetweetServiceImpl(RetweetRepository retweetRepository, RetweetMapper retweetMapper){
        this.retweetRepository = retweetRepository;
        this.retweetMapper = retweetMapper;
    }

    @Override
    public RetweetResponseDto retweet(String source) {
        Retweet retweet = new Retweet();
        retweet.setSource(source);
        Retweet savedRetweet = retweetRepository.save(retweet);
        return retweetMapper.toResponseDto(savedRetweet);
    }

    @Override
    public void delete(Long retweetId) {
        Retweet deleteRetweet = retweetRepository.findById(retweetId)
                .orElseThrow(() -> new RetweetException("Id bulunamadı!" + retweetId));
        retweetRepository.delete(deleteRetweet);
    }
}

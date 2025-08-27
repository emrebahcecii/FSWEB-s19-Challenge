package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetResponseDto;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;
import com.example.FSWEB_s19_challenge.exception.TweetException;
import com.example.FSWEB_s19_challenge.mapper.TweetMapper;
import com.example.FSWEB_s19_challenge.repository.TweetRepository;
import com.example.FSWEB_s19_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService{

    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;
    private UserRepository userRepository;

    public TweetServiceImpl(TweetRepository tweetRepository, TweetMapper tweetMapper) {
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
    }

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository, TweetMapper tweetMapper, UserRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TweetResponseDto create(TweetRequestDto tweetRequestDto) {
        Tweet tweet = tweetMapper.toEntity(tweetRequestDto);

        User user = userRepository.findById(tweetRequestDto.userId())
                .orElseThrow(() -> new TweetException("Kullanıcı bulunamadı!"));
        tweet.setUser(user);

        Tweet saved = tweetRepository.save(tweet);
        return tweetMapper.toResponseDto(saved);
    }

    @Override
    public List<TweetResponseDto> findByUserId(Long userId) {
        List<Tweet> tweets = tweetRepository.findByUserId(userId);
        if (tweets.isEmpty()) {
            throw new TweetException("Kullanıcıya ait tweet bulunamadı!");
        }
        return tweets.stream().map(u -> tweetMapper.toResponseDto(u)).toList();
    }

    @Override
    public TweetResponseDto findById(Long id) {
        Tweet tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new TweetException("Id'ye ait bilgi bulunamadı! "+id));
        return tweetMapper.toResponseDto(tweet);
    }

    @Override
    public TweetResponseDto update(Long id, TweetPatchRequestDto tweetPatchRequestDto) {
        Tweet updateTweet = tweetRepository.findById(id)
                .orElseThrow(() -> new TweetException("id yok" +id));
        updateTweet = tweetMapper.updateEntity(updateTweet, tweetPatchRequestDto);
        return tweetMapper.toResponseDto(tweetRepository.save(updateTweet));
    }

    @Override
    public void delete(Long id) {
        tweetRepository.deleteById(id);
    }
}

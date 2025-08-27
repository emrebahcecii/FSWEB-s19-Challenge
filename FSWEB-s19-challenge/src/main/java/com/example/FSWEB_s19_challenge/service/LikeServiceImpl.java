package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.entity.Like;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;
import com.example.FSWEB_s19_challenge.exception.LikeException;
import com.example.FSWEB_s19_challenge.exception.LikeOperationException;
import com.example.FSWEB_s19_challenge.repository.LikeRepository;
import com.example.FSWEB_s19_challenge.repository.TweetRepository;
import com.example.FSWEB_s19_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private LikeRepository likeRepository;
    private TweetRepository tweetRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, TweetRepository tweetRepository){
        this.likeRepository = likeRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    public void like(Long tweetId, String mood) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new LikeException("Tweet bulunamadı!"));
        Like like = new Like();
        like.setTweet(tweet);
        like.setMood(mood);
        likeRepository.save(like);

    }

    @Override
    public void disLike(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new LikeException("Tweet bulunamadı!" + tweetId));
        likeRepository.deleteById(tweetId);
    }
}

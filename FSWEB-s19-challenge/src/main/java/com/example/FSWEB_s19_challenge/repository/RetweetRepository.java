package com.example.FSWEB_s19_challenge.repository;

import com.example.FSWEB_s19_challenge.entity.Retweet;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {
    boolean existsByUserAndTweet(User user, Tweet tweet);
}

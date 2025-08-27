package com.example.FSWEB_s19_challenge.repository;

import com.example.FSWEB_s19_challenge.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByUserId(Long userId);
}

package com.example.FSWEB_s19_challenge.repository;

import com.example.FSWEB_s19_challenge.entity.Like;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    boolean existsByTweetAndUser(Tweet tweet, User user);
    Optional<Like> findByTweetAndUser(Tweet tweet, User user);
}

package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.CommentPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentResponseDto;
import com.example.FSWEB_s19_challenge.entity.Comment;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.entity.User;
import com.example.FSWEB_s19_challenge.exception.CommentAuthorizationException;
import com.example.FSWEB_s19_challenge.exception.CommentException;
import com.example.FSWEB_s19_challenge.mapper.CommentMapper;
import com.example.FSWEB_s19_challenge.repository.CommentRepository;
import com.example.FSWEB_s19_challenge.repository.TweetRepository;
import com.example.FSWEB_s19_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private TweetRepository tweetRepository;
    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, TweetRepository tweetRepository, CommentMapper commentMapper){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentResponseDto create(CommentRequestDto commentRequestDto) {
        User user = userRepository.findById(commentRequestDto.userId())
                .orElseThrow(() -> new CommentException("Kullanıcı bulunamadı! "+ commentRequestDto.userId()));

        Tweet tweet = tweetRepository.findById(commentRequestDto.tweetId())
                .orElseThrow(() -> new CommentException("Tweet bulunamadı! "+ commentRequestDto.tweetId()));

        Comment comment = commentMapper.toEntity(commentRequestDto);
        comment.setUser(user);
        comment.setTweet(tweet);

        return commentMapper.toResponseDto(commentRepository.save(comment));
    }

    @Override
    public CommentResponseDto update(Long id, CommentPatchRequestDto commentPatchRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentException("Yorum Bulunamadı!" + id));

        commentMapper.updateEntity(comment, commentPatchRequestDto);
        return commentMapper.toResponseDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentException("Yorum bulunamadı!"));

        commentRepository.deleteById(id);
    }
}

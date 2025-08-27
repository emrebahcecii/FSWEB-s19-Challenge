package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetResponseDto;
import com.example.FSWEB_s19_challenge.entity.Tweet;
import com.example.FSWEB_s19_challenge.exception.TweetException;
import com.example.FSWEB_s19_challenge.mapper.TweetMapper;
import com.example.FSWEB_s19_challenge.repository.TweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TweetServiceImplTest {

    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;
    private TweetServiceImpl tweetService;

    @BeforeEach
    void setUp() {
        tweetRepository = mock(TweetRepository.class);
        tweetMapper = mock(TweetMapper.class);
        tweetService = new TweetServiceImpl(tweetRepository, tweetMapper);
    }

    @Test
    void create() {
        TweetRequestDto dto = new TweetRequestDto("deneme tweet",1L);
        Tweet tweet = new Tweet();
        TweetResponseDto responseDto = new TweetResponseDto(1L,"deneme tweet");

        when(tweetMapper.toEntity(dto)).thenReturn(tweet);
        when(tweetRepository.save(tweet)).thenReturn(tweet);
        when(tweetMapper.toResponseDto(tweet)).thenReturn(responseDto);

        TweetResponseDto result = tweetService.create(dto);

        assertNotNull(result);
        assertEquals("deneme tweet", result.content());
        verify(tweetRepository).save(tweet);
    }

    @Test
    void findByUserId_success() {
        Tweet tweet = new Tweet();
        TweetResponseDto responseDto = new TweetResponseDto(1L,"tweet-1");

        when(tweetRepository.findByUserId(1L)).thenReturn(List.of(tweet));
        when(tweetMapper.toResponseDto(tweet)).thenReturn(responseDto);

        List<TweetResponseDto> result = tweetService.findByUserId(1L);

        assertEquals(1, result.size());
        assertEquals("tweet-1", result.get(0).content());
        verify(tweetRepository).findByUserId(1L);
    }

    @Test
    void findByUserId_notFound() {
        when(tweetRepository.findByUserId(1L)).thenReturn(List.of());

        assertThrows(TweetException.class, () -> tweetService.findByUserId(1L));
    }

    @Test
    void findById_success() {
        Tweet tweet = new Tweet();
        TweetResponseDto responseDto = new TweetResponseDto(1L,"tweet-by-id");

        when(tweetRepository.findById(1L)).thenReturn(Optional.of(tweet));
        when(tweetMapper.toResponseDto(tweet)).thenReturn(responseDto);

        TweetResponseDto result = tweetService.findById(1L);

        assertNotNull(result);
        assertEquals("tweet-by-id", result.content());
        verify(tweetRepository).findById(1L);
    }

    @Test
    void findById_notFound() {
        when(tweetRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(TweetException.class, () -> tweetService.findById(1L));
    }

    @Test
    void update_success() {
        TweetPatchRequestDto patchDto = new TweetPatchRequestDto("yeni tweet");
        Tweet tweet = new Tweet();
        Tweet updatedTweet = new Tweet();
        TweetResponseDto responseDto = new TweetResponseDto(1L,"yeni tweet");

        when(tweetRepository.findById(1L)).thenReturn(Optional.of(tweet));
        when(tweetMapper.updateEntity(tweet, patchDto)).thenReturn(updatedTweet);
        when(tweetRepository.save(updatedTweet)).thenReturn(updatedTweet);
        when(tweetMapper.toResponseDto(updatedTweet)).thenReturn(responseDto);

        TweetResponseDto result = tweetService.update(1L, patchDto);

        assertNotNull(result);
        assertEquals("yeni tweet", result.content());
        verify(tweetRepository).save(updatedTweet);
    }

    @Test
    void update_notFound() {
        TweetPatchRequestDto patchDto = new TweetPatchRequestDto("yeni tweet");

        when(tweetRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(TweetException.class, () -> tweetService.update(1L, patchDto));
    }

    @Test
    void delete() {
        doNothing().when(tweetRepository).deleteById(1L);

        tweetService.delete(1L);

        verify(tweetRepository).deleteById(1L);
    }
}

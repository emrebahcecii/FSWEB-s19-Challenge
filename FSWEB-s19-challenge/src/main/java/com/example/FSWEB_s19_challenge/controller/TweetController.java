package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.TweetPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.TweetResponseDto;
import com.example.FSWEB_s19_challenge.service.TweetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tweet")
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService){
        this.tweetService = tweetService;
    }

    @PostMapping()
    public TweetResponseDto create (@RequestBody TweetRequestDto tweetRequestDto){
        return tweetService.create(tweetRequestDto);
    }

    @GetMapping("/findByUserId/{userId}")
    public List<TweetResponseDto> findByUserId(@PathVariable Long userId){
        return tweetService.findByUserId(userId);
    }

    @GetMapping("/findById/{id}")
    public TweetResponseDto findById(@PathVariable Long id){
        return tweetService.findById(id);
    }


    @PatchMapping("/{id}")
    public TweetResponseDto update(@PathVariable Long id, @RequestBody TweetPatchRequestDto tweetPatchRequestDto) {
        return tweetService.update(id, tweetPatchRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        tweetService.delete(id);
    }

    @GetMapping("/findByUserId")
    public List<TweetResponseDto> findByUserIdi(@RequestParam Long userId) {
        return tweetService.findByUserId(userId);
    }

}

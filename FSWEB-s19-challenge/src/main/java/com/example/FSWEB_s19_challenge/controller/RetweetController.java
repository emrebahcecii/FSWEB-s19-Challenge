package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.RetweetRequestDto;
import com.example.FSWEB_s19_challenge.dto.RetweetResponseDto;
import com.example.FSWEB_s19_challenge.service.RetweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retweet")
public class RetweetController {

    private RetweetService retweetService;

    @Autowired
    public RetweetController(RetweetService retweetService){
        this.retweetService = retweetService;
    }

    @PostMapping()
    public RetweetResponseDto retweet(@RequestBody RetweetRequestDto request) {
        String source = request.source();
        return retweetService.retweet(source);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        retweetService.delete(id);
    }
}

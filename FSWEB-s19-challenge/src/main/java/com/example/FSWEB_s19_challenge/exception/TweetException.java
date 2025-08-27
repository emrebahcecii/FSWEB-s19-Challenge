package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class TweetException extends UserException{

    public TweetException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

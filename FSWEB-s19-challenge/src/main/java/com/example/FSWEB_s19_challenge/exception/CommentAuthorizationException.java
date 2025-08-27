package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class CommentAuthorizationException extends UserException{
    public CommentAuthorizationException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}

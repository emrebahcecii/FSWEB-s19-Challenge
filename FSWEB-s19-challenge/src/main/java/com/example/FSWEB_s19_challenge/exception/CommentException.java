package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class CommentException extends UserException{

    public CommentException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

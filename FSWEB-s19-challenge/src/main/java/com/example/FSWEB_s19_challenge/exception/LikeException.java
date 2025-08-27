package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class LikeException extends UserException{

    public LikeException(String message) {
        super(message, HttpStatus.NOT_FOUND );
    }
}

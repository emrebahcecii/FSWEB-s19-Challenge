package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class LikeOperationException extends UserException{

    public LikeOperationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

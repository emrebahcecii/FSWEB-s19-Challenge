package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;

public class RetweetException extends UserException{

    public RetweetException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

package com.example.FSWEB_s19_challenge.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException{

    private HttpStatus httpStatus;

    public UserException(String message, HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}

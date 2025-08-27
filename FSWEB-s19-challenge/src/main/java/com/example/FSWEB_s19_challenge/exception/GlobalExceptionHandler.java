package com.example.FSWEB_s19_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserException userException){
        UserErrorResponse response
                = new UserErrorResponse(userException.getHttpStatus().value(),
                userException.getMessage());
        return new ResponseEntity<>(response, userException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exception){
        UserErrorResponse response
                = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

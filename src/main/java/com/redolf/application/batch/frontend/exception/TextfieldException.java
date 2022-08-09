package com.redolf.application.batch.frontend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class TextfieldException {

    @ExceptionHandler(CustomException.class)
    public static TextfieldException emptyfieldException(CustomException exception){
        ErrorDetails details = new ErrorDetails();
        details.setTimestamp(LocalTime.now());
        details.setMessage(exception.getMessage());
        return new TextfieldException();
    }
}

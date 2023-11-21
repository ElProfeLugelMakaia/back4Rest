package com.makaia.test.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MakaiaApiExceptionHandler {

    @ExceptionHandler(value = { MakaiaApiException.class })
    public ResponseEntity<Object> handleMakaia(MakaiaApiException e){
        MakaiaErrorResponse error = new MakaiaErrorResponse(e.getMessage(), 404, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<Object> handleNoSuchElement(NoSuchElementException e){
        MakaiaErrorResponse error = new MakaiaErrorResponse("Error inesperado: " + e.getMessage(), 404, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { ArithmeticException.class })
    public ResponseEntity<Object> zeroDivision(NoSuchElementException e){
        MakaiaErrorResponse error = new MakaiaErrorResponse("Error inesperado: " + e.getMessage(), 404, ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

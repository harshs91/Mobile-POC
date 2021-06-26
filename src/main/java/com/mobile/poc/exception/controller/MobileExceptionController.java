package com.mobile.poc.exception.controller;

import com.mobile.poc.exception.model.MobileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MobileExceptionController {

    @ExceptionHandler(value = MobileNotFoundException.class)
    public ResponseEntity<Object> mobileNotFound(MobileNotFoundException mobileNotFoundException){
        return new ResponseEntity<>("Mobile with the given Id not found.", HttpStatus.NOT_FOUND);
    }
}

package com.learn.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.bean.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(OrderException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
}

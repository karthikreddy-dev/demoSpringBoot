package com.example.demo_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<String> handleInvalidAgeException(InvalidAgeException invalidAgeException){
		return new ResponseEntity<>(invalidAgeException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

package com.example.demo_springboot.exception;

public class InvalidAgeException extends RuntimeException{

	public InvalidAgeException(String msg) {
		super(msg);
	}
}

package com.bankapp.exception.service_exceptions.user_service;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}

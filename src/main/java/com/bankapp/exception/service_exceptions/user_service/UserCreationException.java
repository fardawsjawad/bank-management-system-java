package com.bankapp.exception.service_exceptions.user_service;

public class UserCreationException extends RuntimeException{
    public UserCreationException(String message) {
        super(message);
    }
    public UserCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

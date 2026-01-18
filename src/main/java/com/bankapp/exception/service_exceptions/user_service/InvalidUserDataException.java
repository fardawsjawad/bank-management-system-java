package com.bankapp.exception.service_exceptions.user_service;

public class InvalidUserDataException extends RuntimeException{
    public InvalidUserDataException(String message) {
        super(message);
    }
}

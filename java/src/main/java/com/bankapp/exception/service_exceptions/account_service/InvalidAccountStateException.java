package com.bankapp.exception.service_exceptions.account_service;

public class InvalidAccountStateException extends RuntimeException{
    public InvalidAccountStateException(String message) {
        super(message);
    }
    public InvalidAccountStateException(String message, Throwable cause) {
        super(message, cause);
    }
}

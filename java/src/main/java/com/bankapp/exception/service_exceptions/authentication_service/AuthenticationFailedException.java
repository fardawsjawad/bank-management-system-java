package com.bankapp.exception.service_exceptions.authentication_service;

public class AuthenticationFailedException extends RuntimeException{
    public AuthenticationFailedException(String message){
        super(message);
    }
    public AuthenticationFailedException(String message, Throwable cause){
        super(message, cause);
    }
}

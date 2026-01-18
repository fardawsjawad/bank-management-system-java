package com.bankapp.exception.service_exceptions.user_service;

public class UserException extends RuntimeException{
    public UserException(String message){
        super(message);
    }
    public UserException(String message,Throwable cause){
        super(message,cause);
    }
}

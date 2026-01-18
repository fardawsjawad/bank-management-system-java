package com.bankapp.exception.service_exceptions.user_service;

public class EmailAddressNotFoundException extends RuntimeException{
    public EmailAddressNotFoundException(String message){
        super(message);
    }
    public EmailAddressNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}

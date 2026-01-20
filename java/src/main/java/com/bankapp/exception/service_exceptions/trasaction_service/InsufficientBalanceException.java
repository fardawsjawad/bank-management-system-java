package com.bankapp.exception.service_exceptions.trasaction_service;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
    public InsufficientBalanceException(String message, Throwable cause){
        super(message,cause);
    }
}

package com.bankapp.exception.service_exceptions.account_service;

public class AccountNotFoundException   extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

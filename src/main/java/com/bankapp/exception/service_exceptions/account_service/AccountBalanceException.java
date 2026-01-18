package com.bankapp.exception.service_exceptions.account_service;

public class AccountBalanceException extends RuntimeException {
    public AccountBalanceException(String message) {
        super(message);
    }
    public AccountBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}

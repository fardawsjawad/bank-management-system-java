package com.bankapp.exception.DAO_exceptions;

public class AccountAccessException extends RuntimeException{
    public AccountAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

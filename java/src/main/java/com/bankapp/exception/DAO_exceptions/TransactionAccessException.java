package com.bankapp.exception.DAO_exceptions;

public class TransactionAccessException extends RuntimeException{
    public TransactionAccessException (String message, Throwable cause) {
        super(message, cause);
    }
}

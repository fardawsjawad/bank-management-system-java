package com.bankapp.exception.DAO_exceptions;

public class DepositException extends RuntimeException{
    public DepositException(String message){
        super(message);
    }
    public DepositException (String message, Throwable cause) {
        super(message, cause);
    }
}

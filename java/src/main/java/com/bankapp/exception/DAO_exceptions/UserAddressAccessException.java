package com.bankapp.exception.DAO_exceptions;

public class UserAddressAccessException extends RuntimeException{
    public UserAddressAccessException (String message, Throwable cause) {
        super(message, cause);
    }

}

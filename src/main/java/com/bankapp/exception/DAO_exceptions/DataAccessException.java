package com.bankapp.exception.DAO_exceptions;

public class DataAccessException extends RuntimeException{

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.bankapp.exception.DAO_exceptions;

public class UserRoleAccessException extends RuntimeException{
    public UserRoleAccessException (String message, Throwable cause) {
        super(message, cause);
    }

}

package com.bankapp.exception.service_exceptions.user_role;

public class UserRoleCreationException extends RuntimeException{
    public UserRoleCreationException(){}
    public UserRoleCreationException(String message){
        super(message);
    }
    public UserRoleCreationException(String message, Throwable cause){
        super(message, cause);
    }
}

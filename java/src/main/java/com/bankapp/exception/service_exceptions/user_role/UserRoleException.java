package com.bankapp.exception.service_exceptions.user_role;

public class UserRoleException extends RuntimeException{
    public UserRoleException(){
    }
    public UserRoleException(String message){
        super(message);
    }
    public UserRoleException(String message, Throwable cause){
        super(message, cause);
    }
}

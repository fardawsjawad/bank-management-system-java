package com.bankapp.exception.service_exceptions.user_address_service;

public class UserAddressCreationException extends RuntimeException{
    public UserAddressCreationException(){
    }
    public UserAddressCreationException(String message){
        super(message);
    }
    public UserAddressCreationException(String message, Throwable cause){
        super(message, cause);
    }
}

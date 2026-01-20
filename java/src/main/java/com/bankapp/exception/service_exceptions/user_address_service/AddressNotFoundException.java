package com.bankapp.exception.service_exceptions.user_address_service;

public class AddressNotFoundException extends  RuntimeException{
    public AddressNotFoundException(String message){
        super(message);
    }
    public AddressNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}

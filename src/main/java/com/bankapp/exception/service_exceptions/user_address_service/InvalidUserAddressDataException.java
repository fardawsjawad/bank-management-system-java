package com.bankapp.exception.service_exceptions.user_address_service;

public class InvalidUserAddressDataException extends RuntimeException{
    public InvalidUserAddressDataException(String message) {
        super(message);
    }
    public InvalidUserAddressDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

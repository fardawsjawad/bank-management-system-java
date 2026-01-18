package com.bankapp.exception.service_exceptions.user_address_service;

public class UserAddressException extends RuntimeException {
    public UserAddressException(String message) {
        super(message);
    }
    public UserAddressException(String message, Throwable cause) {
        super(message, cause);
    }
}

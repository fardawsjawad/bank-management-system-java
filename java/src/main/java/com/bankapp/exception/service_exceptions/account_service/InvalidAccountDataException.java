package com.bankapp.exception.service_exceptions.account_service;

public class InvalidAccountDataException extends RuntimeException {
    public InvalidAccountDataException(String message) {
        super(message);
    }

}

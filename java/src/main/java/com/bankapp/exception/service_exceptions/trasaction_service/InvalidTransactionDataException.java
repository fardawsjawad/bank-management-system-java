package com.bankapp.exception.service_exceptions.trasaction_service;

public class InvalidTransactionDataException extends RuntimeException {
    public InvalidTransactionDataException(String message) {
        super(message);
    }
}

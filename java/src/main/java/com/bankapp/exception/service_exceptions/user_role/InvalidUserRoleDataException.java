package com.bankapp.exception.service_exceptions.user_role;

public class InvalidUserRoleDataException extends RuntimeException {
    public InvalidUserRoleDataException() {
    }
    public InvalidUserRoleDataException(String message) {
        super(message);
    }
    public InvalidUserRoleDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.bankapp.exception.service_exceptions.employment_profile;

public class EmploymentProfileException extends RuntimeException {
    public EmploymentProfileException() {
    }
    public EmploymentProfileException(String message) {
        super(message);
    }
    public EmploymentProfileException(String message, Throwable cause) {
        super(message, cause);
    }
}

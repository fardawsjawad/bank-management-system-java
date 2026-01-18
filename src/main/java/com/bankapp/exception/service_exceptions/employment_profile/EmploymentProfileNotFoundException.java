package com.bankapp.exception.service_exceptions.employment_profile;

public class EmploymentProfileNotFoundException extends RuntimeException {
    public EmploymentProfileNotFoundException(String message) {
        super(message);
    }
    public EmploymentProfileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

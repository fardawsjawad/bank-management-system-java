package com.bankapp.exception.service_exceptions.employment_profile;

public class EmploymentProfileCreationException extends RuntimeException{
    public EmploymentProfileCreationException(String message) {
        super(message);
    }
    public EmploymentProfileCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

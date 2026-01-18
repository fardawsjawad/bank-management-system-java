package com.bankapp.exception.service_exceptions.employment_profile;

public class InvalidEmploymentProfileDataException extends RuntimeException {
    public InvalidEmploymentProfileDataException(String message) {
        super(message);
    }
    public InvalidEmploymentProfileDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

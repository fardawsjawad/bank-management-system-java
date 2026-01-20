package com.bankapp.exception.DAO_exceptions;

/**
 * Custom exception class for DAO layer.
 * Wraps SQLExceptions and other persistence-related exceptions
 * to provide a consistent exception type for the service layer.
 */
public class DAOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new DAOException with the specified detail message.
     *
     * @param message the detail message
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Constructs a new DAOException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause   the cause (which is saved for later retrieval by the Throwable.getCause() method)
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DAOException with the specified cause.
     *
     * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method)
     */
    public DAOException(Throwable cause) {
        super(cause);
    }
}


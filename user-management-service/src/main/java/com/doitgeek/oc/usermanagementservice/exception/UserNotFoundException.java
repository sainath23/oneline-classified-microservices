package com.doitgeek.oc.usermanagementservice.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3691981188409728253L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}

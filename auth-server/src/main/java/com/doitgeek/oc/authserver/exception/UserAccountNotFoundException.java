package com.doitgeek.oc.authserver.exception;

public class UserAccountNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6272985637557012544L;

    public UserAccountNotFoundException(String message) {
        super(message);
    }

    public UserAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountNotFoundException(Throwable cause) {
        super(cause);
    }
}

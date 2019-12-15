package com.doitgeek.oc.categorymanagementservice.exception;

public class CategoryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -8773725346524887770L;

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }
}

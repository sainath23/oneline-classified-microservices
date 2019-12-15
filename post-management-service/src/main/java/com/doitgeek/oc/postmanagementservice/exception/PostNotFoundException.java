package com.doitgeek.oc.postmanagementservice.exception;

public class PostNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1823839960056331428L;

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundException(Throwable cause) {
        super(cause);
    }
}

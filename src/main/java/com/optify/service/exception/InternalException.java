package com.optify.service.exception;

public class InternalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InternalException() {
    }

    public InternalException(Throwable cause) {
        super(cause);
    }
}

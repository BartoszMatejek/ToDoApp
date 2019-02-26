package com.ToDoApp.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1359744478001140750L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String exception) {
        super(exception);
    }

    public ResourceNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ResourceNotFoundException(String exception, Throwable throwable) {
        super(throwable);
    }
}

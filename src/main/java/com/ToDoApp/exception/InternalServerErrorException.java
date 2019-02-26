package com.ToDoApp.exception;

public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = -2988795206356015522L;

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String s) {
        super(s);
    }

    public InternalServerErrorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InternalServerErrorException(Throwable throwable) {
        super(throwable);
    }
}

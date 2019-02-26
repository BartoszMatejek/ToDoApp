package com.ToDoApp.exception;

public class DataValidationException extends RuntimeException {

    private static final long serialVersionUID = -6163684062511597569L;

    private String validationMessage;

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException(Throwable throwable) {
        super(throwable);
    }

    public DataValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataValidationException(String message, String validationMessage) {
        super(message);
        this.validationMessage = validationMessage;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }
}

package ru.pilot.exception;

public class UpdateValidationError extends RuntimeException {
    public UpdateValidationError() {
        super("Validation failed.");
    }

    public UpdateValidationError(String message) {
        super(message);
    }
}

package ru.pilot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.pilot.exception.AccountNotFoundException;
import ru.pilot.exception.AccountTypeNotFoundException;
import ru.pilot.exception.CurrencyNotFoundException;
import ru.pilot.exception.UpdateValidationError;
import ru.pilot.model.response.ErrorDtoResponse;

import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler({
                    UpdateValidationError.class,
                    AccountNotFoundException.class,
                    AccountTypeNotFoundException.class,
                    CurrencyNotFoundException.class
            })
    public ResponseEntity<?> handeNotFound(Exception ex) {
        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler({TimeoutException.class})
    public ResponseEntity<?> handleTimeoutException(TimeoutException ex) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<?> buildResponse(HttpStatus httpStatus, String message){
        return ResponseEntity.status(httpStatus.value()).body(new ErrorDtoResponse(message));
    }
}

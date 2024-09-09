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
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.badRequest().body(new ErrorDtoResponse(ex.getMessage()));
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> handeAccountNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse(ex.getMessage()));
    }
    @ExceptionHandler(AccountTypeNotFoundException.class)
    public ResponseEntity<?> handeAccountTypeNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse(ex.getMessage()));
    } 
    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<?> handeCurrencyNotFoundException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse(ex.getMessage()));
    }
    @ExceptionHandler(UpdateValidationError.class)
    public ResponseEntity<?> handeUpdateValidationError(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse(ex.getMessage()));
    }

    @ExceptionHandler({TimeoutException.class})
    public ResponseEntity<?> handleTimeoutException(TimeoutException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ErrorDtoResponse(ex.getMessage()));
    }
}

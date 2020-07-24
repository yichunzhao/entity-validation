package com.ynz.entityautovalidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String VIOLATION_ERR_MSG = "There are constraint violation errors.";

    /**
     * Jpa and Hibernate constraint violation exception is wrapped in the TransactionSystemException.
     * <p>
     * Tuning exception handlers may need several iterations.
     */
    @ExceptionHandler
    public ResponseEntity<List<String>> handleConstrainViolationException(TransactionSystemException e) {
        List<String> errors = new ArrayList<>();
        String message = null;

        Throwable currentCause = e.getCause();
        if (currentCause instanceof RollbackException) {

            currentCause = currentCause.getCause();

            if (currentCause instanceof ConstraintViolationException) {

                ConstraintViolationException violationException = (ConstraintViolationException) currentCause;
                message = VIOLATION_ERR_MSG;

                violationException.getConstraintViolations()
                        .forEach(constraintViolation -> errors.add(constraintViolation.getMessage()));
            }
        }

        return new ResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, message, errors), HttpStatus.BAD_REQUEST);
    }

}

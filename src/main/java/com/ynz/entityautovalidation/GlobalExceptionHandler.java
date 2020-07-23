package com.ynz.entityautovalidation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * There is an issue how to catch the Constraint violation exception. Jpa and Hibernate constraint violation
     * exception is wrapped in the TransactionSystemException.
     */
    @ExceptionHandler
    public ResponseEntity<String> handleConstrainViolationException(TransactionSystemException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

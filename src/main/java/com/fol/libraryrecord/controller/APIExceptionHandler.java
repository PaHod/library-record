package com.fol.libraryrecord.controller;

import com.fol.libraryrecord.exception.LibraryRecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(LibraryRecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException(LibraryRecordNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
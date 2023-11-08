package com.fol.libraryrecord.exception;

public class LibraryRecordNotFoundException extends RuntimeException {
    public LibraryRecordNotFoundException(long id) {
        super(String.format("Record not found with id: %s", id));
    }
}

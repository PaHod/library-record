package com.fol.libraryrecord.exception;

public class NoUserPermissionException extends RuntimeException {
    public NoUserPermissionException(long id) {
        super(String.format("User with id: % doesn't have permission to take book", id));
    }
}

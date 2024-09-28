package com.fiuni.mytube_security.exception_handler.exceptions;

public class UsernameFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameFoundException(String message) {
        super(message);
    }
}
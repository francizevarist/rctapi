package com.rct.app.exception.forbidden;

public class ApiForbiddenException extends RuntimeException{
    public ApiForbiddenException(String message) {
        super(message);
    }
}
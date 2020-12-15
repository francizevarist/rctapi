package com.rct.app.exception.unauthorized;

public class ApiUnauthorizedException extends RuntimeException{
    public ApiUnauthorizedException(String message) {
        super(message);
    }
}
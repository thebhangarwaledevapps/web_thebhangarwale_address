package com.app.address.exception;

public class InvalidLatLongException extends RuntimeException {

    public InvalidLatLongException(String message) {
        super(message);
    }
}

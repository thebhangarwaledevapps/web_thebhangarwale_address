package com.app.address.exception;

public class NoAddressAvailableException extends RuntimeException{

    @Override
    public String getMessage() {
        return "error_something_went_wrong";
    }
}

package com.app.address.exception;

public class SomethingWentWrongException extends RuntimeException{

    @Override
    public String getMessage() {
        return "error_something_went_wrong";
    }
}

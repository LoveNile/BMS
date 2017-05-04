package com.bms.exception;

public class LoginErrorException extends BaseException {

    private static final long serialVersionUID = 1L;

    public LoginErrorException(String errorMessage) {
        super(errorMessage);

    }
}

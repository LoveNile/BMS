package com.bms.exception;


public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public BaseException(int errorCode) {
        setErrorCode(errorCode);
    }
    public BaseException(String errorMessage) {
        super(errorMessage);

    }
    public BaseException(int errorCode, String message) {
        super(message);
        setErrorCode(errorCode);
    }
    public BaseException(int errorCode, String errormessage, Throwable throwable) {
        super(errormessage, throwable);
        setErrorCode(errorCode);
    }

}

package com.bornya.ismedia.exception;

public abstract class AppRootException extends RuntimeException{
    public AppRootException(){
        super();
    }

    public AppRootException(String message){
        super(message);
    }

    public AppRootException(Throwable cause) {
        super(cause);
    }

    protected AppRootException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

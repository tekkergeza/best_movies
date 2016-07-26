package org.tek.geza.bestmovies.util.network;

import java.io.IOException;

public class RetrofitException extends Exception {
    String message;
    int code;
    Throwable exception;

    boolean networkError;

    public static RetrofitException networkError(IOException throwable) {
        RetrofitException exception = new RetrofitException();
        exception.setException(throwable);
        exception.setNetworkError(true);
        return exception;
    }

    public static RetrofitException unexpectedError(Throwable throwable) {
        RetrofitException exception = new RetrofitException();
        exception.setException(throwable);
        exception.setNetworkError(false);
        return exception;
    }

    public static RetrofitException httpError(String message, int code) {
        RetrofitException exception = new RetrofitException();
        exception.setNetworkError(false);
        exception.setMessage(message);
        exception.setCode(code);
        return exception;
    }

    public boolean isNetworkError() {
        return networkError;
    }

    public void setNetworkError(boolean networkError) {
        this.networkError = networkError;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}

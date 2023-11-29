package com.hfish.dev.dexapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.HttpResponse;

public class ErrorResponse {
    private String message;
    private String httpStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpResponse) {
        this.httpStatus = httpResponse;
    }
}

package com.hfish.dev.dexapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoModelFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoModelFoundException(NoModelFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No model found with corresponding name");
        errorResponse.setHttpResponse(HttpStatus.NOT_FOUND.toString());
        return errorResponse;
    }
}

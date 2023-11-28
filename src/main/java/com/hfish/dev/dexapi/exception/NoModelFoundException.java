package com.hfish.dev.dexapi.exception;

public class NoModelFoundException extends RuntimeException {
    /**
     * NoModelFoundException is thrown when our expected model is not found after parsing html document.
     * If user searches for a valid model name, a response object should always be returned
     */
    public NoModelFoundException() {
        super();
    }
}

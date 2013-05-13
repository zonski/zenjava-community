package com.zenjava.community.service.data.exception;

public class SystemNotSetupException extends RuntimeException {

    public SystemNotSetupException(String message) {
        super(message);
    }

    public SystemNotSetupException(String message, Throwable cause) {
        super(message, cause);
    }
}

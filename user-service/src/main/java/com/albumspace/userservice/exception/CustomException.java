package com.albumspace.userservice.exception;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomException extends RuntimeException {

    private final String errorCode;

    public CustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

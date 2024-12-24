package com.albumspace.userservice.exception;

import com.albumspace.userservice.dto.StandardResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public StandardResponse<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return StandardResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .errorCode("USER_NOT_FOUND")
                .build();
    }

    @ExceptionHandler(DuplicateUserException.class)
    public StandardResponse<Object> handleDuplicateUserException(DuplicateUserException ex) {
        ex.printStackTrace();
        return StandardResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .errorCode("DUPLICATE_USER")
                .build();
    }

    @ExceptionHandler(Exception.class)
    public StandardResponse<Object> handleGeneralException(Exception ex) {
        ex.printStackTrace();
        return StandardResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .errorCode("INTERNAL_ERROR")
                .build();
    }

    @ExceptionHandler(CustomException.class)
    public StandardResponse<Object> handleCustomException(CustomException ex) {
        ex.printStackTrace();
        return StandardResponse.builder()
                .timestamp(LocalDateTime.now())
                .error(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .build();
    }

}


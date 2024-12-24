package com.albumspace.mediaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class StandardResponse<T> {
    private T data;           // The actual response data
    private String error;     // Error message, null if no error
    private String errorCode; // Optional error code, null if no error
    private LocalDateTime timestamp; // Timestamp of the response
    private String message;
    private String status;

}

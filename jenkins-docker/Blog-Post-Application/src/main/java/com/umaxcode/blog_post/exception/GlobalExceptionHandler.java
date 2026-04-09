package com.umaxcode.blog_post.exception;

import com.umaxcode.blog_post.domain.dtos.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ExceptionResponse> handleServiceException(ServiceException ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .path(request.getServletPath())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}

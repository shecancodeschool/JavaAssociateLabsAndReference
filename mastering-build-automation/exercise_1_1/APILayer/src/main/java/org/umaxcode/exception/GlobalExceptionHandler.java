package org.eddydashcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.eddydashcode.dto.ResponseMessage;
import org.eddydashcode.service.exception.PostException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage badRequestHandler(PostException ex) {

        return ResponseMessage.builder()
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage requestValidationExceptionHandler(MethodArgumentNotValidException ex) {

        // Extract field errors
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> {
                            String message = fieldError.getDefaultMessage();
                            return message != null ? message : "(no message)";
                        },
                        (existing, replacement) -> existing
                ));

        return ResponseMessage.builder()
                .message("Request validation error")
                .data(errors)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMessage notFoundRequestHandler(Exception ex) {

        return ResponseMessage.builder()
                .message(ex.getMessage())
                .build();
    }
}

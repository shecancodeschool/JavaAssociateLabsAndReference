package com.umaxcode.blog_post.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private final String message;

    public ServiceException(String message) {
        this.message = message;
    }
}

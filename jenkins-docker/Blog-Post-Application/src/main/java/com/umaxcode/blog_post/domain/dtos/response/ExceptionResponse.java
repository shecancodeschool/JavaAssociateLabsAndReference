package com.umaxcode.blog_post.domain.dtos.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionResponse(
        int code,
        String message,
        String path,
        LocalDateTime timestamp
) {
}

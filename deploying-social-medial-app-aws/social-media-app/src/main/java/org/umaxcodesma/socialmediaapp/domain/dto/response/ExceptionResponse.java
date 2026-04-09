package org.umaxcodesma.socialmediaapp.domain.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ExceptionResponse(
        String message,
        String path,
        LocalDateTime timestamp
) {
}
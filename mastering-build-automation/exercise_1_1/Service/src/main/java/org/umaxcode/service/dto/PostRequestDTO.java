package org.eddydashcode.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PostRequestDTO(
        @NotNull(message = "Title cannot be null")
        @NotBlank(message = "Title cannot be empty")
        String title,

        @NotNull(message = "Content cannot be null")
        @NotBlank(message = "Content cannot be empty")
        String content
) {
}

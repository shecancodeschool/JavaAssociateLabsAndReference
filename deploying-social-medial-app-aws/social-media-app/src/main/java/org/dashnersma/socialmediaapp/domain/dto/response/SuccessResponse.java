package org.umaxcodesma.socialmediaapp.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SuccessResponse(String message, Object data) {

}

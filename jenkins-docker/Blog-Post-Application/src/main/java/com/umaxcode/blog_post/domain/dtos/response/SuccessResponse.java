package com.umaxcode.blog_post.domain.dtos.response;

import lombok.Builder;

@Builder
public record SuccessResponse(String message, Object data) {

}

package com.umaxcode.blog_post.domain.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostCreationRequestDTO {
    private String title;
    private String content;
    private String author;

}

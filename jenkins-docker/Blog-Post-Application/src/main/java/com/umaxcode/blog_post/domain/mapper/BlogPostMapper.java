package com.umaxcode.blog_post.domain.mapper;

import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.domain.entity.BlogPost;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BlogPostMapper {

    private final ModelMapper modelMapper;

    public BlogPost toBlogPost(PostCreationRequestDTO postCreationRequestDTO) {

        return modelMapper.map(postCreationRequestDTO, BlogPost.class);
    }

    public PostResponseDTO toPostResponseDTO(BlogPost blogPost) {
        return modelMapper.map(blogPost, PostResponseDTO.class);
    }

    public List<PostResponseDTO> toListPostResponseDTO(List<BlogPost> blogPosts) {
        return blogPosts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).toList();
    }
}

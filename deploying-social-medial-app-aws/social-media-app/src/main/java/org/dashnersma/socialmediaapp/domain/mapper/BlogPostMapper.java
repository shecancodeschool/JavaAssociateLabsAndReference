package org.umaxcodesma.socialmediaapp.domain.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.umaxcodesma.socialmediaapp.domain.dto.request.PostCreationRequestDTO;
import org.umaxcodesma.socialmediaapp.domain.dto.response.PostResponseDTO;
import org.umaxcodesma.socialmediaapp.domain.entity.Post;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BlogPostMapper {

    private final ModelMapper modelMapper;

    public Post toBlogPost(PostCreationRequestDTO postCreationRequestDTO) {
        return modelMapper.map(postCreationRequestDTO, Post.class);
    }

    public PostResponseDTO toPostResponseDTO(Post post) {
        return modelMapper.map(post, PostResponseDTO.class);
    }

    public List<PostResponseDTO> toListPostResponseDTO(List<Post> blogPosts) {
        return blogPosts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).toList();
    }
}
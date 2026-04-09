package com.umaxcode.blog_post.service;

import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.domain.entity.BlogPost;

import java.util.List;

public interface BlogPostService {

    PostResponseDTO createBlogPost(PostCreationRequestDTO request);

    List<PostResponseDTO> getBlogPosts();

    PostResponseDTO getBlogPost(Long id);

    void deleteBlogPost(Long id);

    PostResponseDTO updateBlogPost(Long postId, PostCreationRequestDTO request);
}

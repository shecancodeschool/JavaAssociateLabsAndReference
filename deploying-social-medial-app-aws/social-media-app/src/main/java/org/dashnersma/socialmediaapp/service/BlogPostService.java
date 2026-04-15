package org.umaxcodesma.socialmediaapp.service;

import org.umaxcodesma.socialmediaapp.domain.dto.request.PostCreationRequestDTO;
import org.umaxcodesma.socialmediaapp.domain.dto.response.PostResponseDTO;

import java.util.List;

public interface BlogPostService {

    PostResponseDTO createBlogPost(PostCreationRequestDTO request);

    List<PostResponseDTO> getBlogPosts();

    PostResponseDTO getBlogPost(String id);

    void deleteBlogPost(String id);

    PostResponseDTO updateBlogPost(String postId, PostCreationRequestDTO request);
}

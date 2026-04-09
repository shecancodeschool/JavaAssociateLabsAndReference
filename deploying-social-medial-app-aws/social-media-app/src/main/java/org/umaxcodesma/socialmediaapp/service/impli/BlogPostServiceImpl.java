package org.umaxcodesma.socialmediaapp.service.impli;


import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.umaxcodesma.socialmediaapp.domain.dto.request.PostCreationRequestDTO;
import org.umaxcodesma.socialmediaapp.domain.dto.response.PostResponseDTO;
import org.umaxcodesma.socialmediaapp.domain.entity.Post;
import org.umaxcodesma.socialmediaapp.domain.mapper.BlogPostMapper;
import org.umaxcodesma.socialmediaapp.repository.PostRepository;
import org.umaxcodesma.socialmediaapp.service.BlogPostService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final PostRepository postRepository;
    private final BlogPostMapper blogPostMapper;

    @Override
    public PostResponseDTO createBlogPost(PostCreationRequestDTO request) {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Post post = blogPostMapper.toBlogPost(request);
        post.setAuthor(name);
        Post createdBlogPost = postRepository.save(post);
        return blogPostMapper.toPostResponseDTO(createdBlogPost);
    }

    @Override
    public List<PostResponseDTO> getBlogPosts() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Post> allPosts = postRepository.findAllByAuthor(name);

        return blogPostMapper.toListPostResponseDTO(allPosts);
    }

    @Override
    public PostResponseDTO getBlogPost(String id) {

        Post post = getBlog(id);
        return blogPostMapper.toPostResponseDTO(post);
    }

    @Override
    public PostResponseDTO updateBlogPost(String postId, PostCreationRequestDTO request) {
        Post post = getBlog(postId);

        post.setTitle(request.getTitle() != null ? request.getTitle() : post.getTitle());
        post.setContent(request.getContent() != null ? request.getContent() : post.getContent());

        Post updatedBlogPost = postRepository.save(post);
        return blogPostMapper.toPostResponseDTO(updatedBlogPost);
    }

    @Override
    public void deleteBlogPost(String id) {

        Post post = getBlog(id);
        postRepository.delete(post);
    }

    private Post getBlog(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }

        throw new ServiceException("A post with the id " + id + " does not exist.");
    }
}

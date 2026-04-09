package com.umaxcode.blog_post.service.impl;

import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.domain.entity.BlogPost;
import com.umaxcode.blog_post.domain.mapper.BlogPostMapper;
import com.umaxcode.blog_post.exception.ServiceException;
import com.umaxcode.blog_post.repository.BlogPostRepository;
import com.umaxcode.blog_post.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostMapper blogPostMapper;

    @Override
    public PostResponseDTO createBlogPost(PostCreationRequestDTO request) {

        BlogPost post = blogPostMapper.toBlogPost(request);
        BlogPost createdBlogPost = blogPostRepository.save(post);
        return blogPostMapper.toPostResponseDTO(createdBlogPost);
    }

    @Override
    public List<PostResponseDTO> getBlogPosts() {

        return blogPostMapper.toListPostResponseDTO(blogPostRepository.findAll());
    }

    @Override
    public PostResponseDTO getBlogPost(Long id) {

        BlogPost blogPost = getBlog(id);
        return blogPostMapper.toPostResponseDTO(blogPost);
    }

    @Override
    public PostResponseDTO updateBlogPost(Long postId, PostCreationRequestDTO request) {
        BlogPost post = getBlog(postId);

        post.setTitle(request.getTitle() != null ? request.getTitle() : post.getTitle());
        post.setContent(request.getContent() != null ? request.getContent() : post.getContent());
        post.setAuthor(request.getAuthor() != null ? request.getAuthor() : post.getAuthor());

        BlogPost updatedBlogPost = blogPostRepository.save(post);
        return blogPostMapper.toPostResponseDTO(updatedBlogPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        BlogPost post = getBlog(id);
        blogPostRepository.delete(post);
    }

    private BlogPost getBlog(Long id) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }

        throw new ServiceException("A post with the id " + id + " does not exist.");
    }
}

package com.umaxcode.blog_post.service;

import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.domain.entity.BlogPost;
import com.umaxcode.blog_post.domain.mapper.BlogPostMapper;
import com.umaxcode.blog_post.repository.BlogPostRepository;
import com.umaxcode.blog_post.service.impl.BlogPostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BlogPostServiceImplTest {

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @Mock
    private BlogPostRepository blogPostRepository;

    @Mock
    private BlogPostMapper blogPostMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBlogPost() {

        PostCreationRequestDTO request = PostCreationRequestDTO.builder()
                .title("This is a title")
                .content("This is a content")
                .author("This is an author")
                .build();

        BlogPost mappedBlogPost = BlogPost.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        BlogPost createdBlogPost = BlogPost.builder()
                .id(1L)
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        PostResponseDTO response = PostResponseDTO.builder()
                .id(1L)
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        when(blogPostMapper.toBlogPost(any(PostCreationRequestDTO.class))).thenReturn(mappedBlogPost);
        when(blogPostRepository.save(any(BlogPost.class))).thenReturn(createdBlogPost);
        when(blogPostMapper.toPostResponseDTO(any(BlogPost.class))).thenReturn(response);

        PostResponseDTO results = blogPostService.createBlogPost(request);

        assertEquals(response.getAuthor(), results.getAuthor());

    }
}
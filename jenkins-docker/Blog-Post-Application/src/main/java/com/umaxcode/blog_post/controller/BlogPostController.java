package com.umaxcode.blog_post.controller;

import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.domain.dtos.response.SuccessResponse;
import com.umaxcode.blog_post.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<SuccessResponse> createBlogPost(@RequestBody PostCreationRequestDTO request) {

        PostResponseDTO createdPost = blogPostService.createBlogPost(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SuccessResponse.builder()
                        .message("Blog post created successfully")
                        .data(createdPost)
                        .build());
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> getAllBlogPost() {

        List<PostResponseDTO> listOfBlogPost = blogPostService.getBlogPosts();

        return ResponseEntity
                .ok(SuccessResponse.builder()
                        .message("All blog posts retrieved successfully")
                        .data(listOfBlogPost)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse> getBlogPost(@PathVariable("id") Long postId) {

        PostResponseDTO blogPost = blogPostService.getBlogPost(postId);

        return ResponseEntity
                .ok(SuccessResponse.builder()
                        .message("A blog post retrieved successfully")
                        .data(blogPost)
                        .build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateBlogPost(@PathVariable("id") Long postId, @RequestBody PostCreationRequestDTO request){

        PostResponseDTO updatedBlogPost = blogPostService.updateBlogPost(postId, request);

        return ResponseEntity
                .ok(SuccessResponse.builder()
                        .message("A blog post retrieved successfully")
                        .data(updatedBlogPost)
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteBlogPost(@PathVariable("id") Long postId) {

        blogPostService.deleteBlogPost(postId);

        return ResponseEntity
                .ok(SuccessResponse.builder()
                        .message("A blog post deleted successfully")
                        .build());
    }
}

package com.umaxcode.blog_post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import com.umaxcode.blog_post.domain.dtos.response.PostResponseDTO;
import com.umaxcode.blog_post.service.BlogPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = BlogPostController.class)
@ActiveProfiles("test")
class BlogPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BlogPostService blogPostService;

    @Test
    void createBlogPost() throws Exception {

        PostCreationRequestDTO postCreationRequestDTO = PostCreationRequestDTO.builder()
                .title("God is good")
                .content("All the time")
                .author("Umaxcode")
                .build();

        String request = objectMapper.writeValueAsString(postCreationRequestDTO);

        PostResponseDTO response = PostResponseDTO.builder()
                .id(1L)
                .title(postCreationRequestDTO.getTitle())
                .content(postCreationRequestDTO.getContent())
                .author(postCreationRequestDTO.getAuthor())
                .build();

        when(blogPostService.createBlogPost(postCreationRequestDTO)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/blog")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value(postCreationRequestDTO.getTitle()));
    }
}
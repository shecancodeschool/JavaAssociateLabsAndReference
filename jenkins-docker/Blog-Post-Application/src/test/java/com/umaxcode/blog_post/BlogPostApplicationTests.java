package com.umaxcode.blog_post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.blog_post.domain.dtos.request.PostCreationRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@ActiveProfiles("test")
class BlogPostApplicationTests {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:latest").withReuse(true);

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", postgreSQLContainer::getUsername); // loaded from the test profile (application-test.properties)
//        registry.add("spring.datasource.password", postgreSQLContainer::getPassword); // same here
    }


    @Test
    void createBlogPost() throws Exception {
        PostCreationRequestDTO creatBlog = PostCreationRequestDTO.builder()
                .title("Good my grace")
                .content("I post I really love")
                .author("Maxwell Odoom")
                .build();

        String request = objectMapper.writeValueAsString(creatBlog);

        mockMvc.perform(MockMvcRequestBuilders.post("/blog")
                        .contentType(APPLICATION_JSON)
                        .content(request)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value(creatBlog.getTitle()))
                .andExpect(jsonPath("$.data.content").value(creatBlog.getContent()))
                .andExpect(jsonPath("$.data.author").value(creatBlog.getAuthor()));
    }

}

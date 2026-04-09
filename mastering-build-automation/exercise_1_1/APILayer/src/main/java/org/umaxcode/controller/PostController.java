package org.eddydashcode.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.eddydashcode.dto.ResponseMessage;
import org.eddydashcode.service.PostService;
import org.eddydashcode.service.dto.PostRequestDTO;
import org.eddydashcode.service.dto.PostResponseDTO;
import org.eddydashcode.service.exception.PostException;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createPost(@Valid @RequestBody PostRequestDTO request) {

        PostResponseDTO response = postService.create(request);

        return ResponseMessage.builder()
                .message("Post created successfully")
                .data(response)
                .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage retrievePost(@PathVariable("id") Long postId) throws PostException {

        PostResponseDTO response = postService.list(postId);

        return ResponseMessage.builder()
                .message("Post retrieved successfully")
                .data(response)
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage retrieveAllPost(@PageableDefault Pageable pageable) {

        Page<PostResponseDTO> response = postService.listAll(pageable);

        return ResponseMessage.builder()
                .message("Posts retrieved successfully")
                .data(response)
                .build();
    }
}

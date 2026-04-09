package org.eddydashcode.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.eddydashcode.model.Post;
import org.eddydashcode.repository.PostRepository;
import org.eddydashcode.service.PostService;
import org.eddydashcode.service.dto.PostRequestDTO;
import org.eddydashcode.service.dto.PostResponseDTO;
import org.eddydashcode.service.exception.PostException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponseDTO create(PostRequestDTO request) {

        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .build();

        Post savedPost = postRepository.save(post);

        return PostResponseDTO.builder()
                .id(savedPost.getId())
                .title(savedPost.getTitle())
                .content(savedPost.getContent())
                .build();
    }

    @Override
    public PostResponseDTO list(Long id) throws PostException {

        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return PostResponseDTO.builder()
                    .id(optionalPost.get().getId())
                    .title(optionalPost.get().getTitle())
                    .content(optionalPost.get().getContent())
                    .build();
        }

        throw new PostException("Post with id = " + id + "not found");
    }

    @Override
    public Page<PostResponseDTO> listAll(Pageable pageable) {

        return postRepository.findAll(pageable)
                .map(post -> PostResponseDTO.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .build());
    }
}

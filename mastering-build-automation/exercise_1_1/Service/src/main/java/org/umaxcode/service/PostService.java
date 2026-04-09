package org.eddydashcode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.eddydashcode.service.dto.PostRequestDTO;
import org.eddydashcode.service.dto.PostResponseDTO;
import org.eddydashcode.service.exception.PostException;

public interface PostService {

    PostResponseDTO create(PostRequestDTO request);

    PostResponseDTO list(Long id) throws PostException;

    Page<PostResponseDTO> listAll(Pageable pageable);

}

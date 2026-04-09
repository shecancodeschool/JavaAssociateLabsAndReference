package com.umaxcode.blog_post.service.impl;

import com.umaxcode.blog_post.domain.entity.PostImage;
import com.umaxcode.blog_post.repository.PostImageRepository;
import com.umaxcode.blog_post.service.FileUploadService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

import static com.umaxcode.blog_post.utils.FIleManipulation.compress;
import static com.umaxcode.blog_post.utils.FIleManipulation.decompress;

@Service("fileUploadDatabase")
@RequiredArgsConstructor
public class DataBaseFileUploadService implements FileUploadService {

    private final PostImageRepository postImageRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void upload(MultipartFile file) throws IOException {

        PostImage postImage = PostImage.builder()
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(compress(file.getBytes()))
                .build();

        postImageRepository.save(postImage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(String fileName) throws FileNotFoundException {

        PostImage postImage = postImageRepository.findByImageName(fileName)
                .orElseThrow(() -> new FileNotFoundException(fileName));

        postImageRepository.delete(postImage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public byte[] preview(String fileName) throws FileNotFoundException, DataFormatException {

        PostImage postImage = postImageRepository.findByImageName(fileName)
                .orElseThrow(() -> new FileNotFoundException(fileName));

        return decompress(postImage.getImageData());
    }
}

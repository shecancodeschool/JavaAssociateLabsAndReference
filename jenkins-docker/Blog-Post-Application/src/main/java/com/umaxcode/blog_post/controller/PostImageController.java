package com.umaxcode.blog_post.controller;

import com.umaxcode.blog_post.service.FileUploadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/images")
public class PostImageController {

    private final FileUploadService fileUploadService;

    public PostImageController(@Qualifier("fileUploadDatabase") FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestPart("file") MultipartFile file) throws IOException {

        fileUploadService.upload(file);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("File uploaded successfully");
    }

    @GetMapping("/preview/{fileName}")
    public ResponseEntity<byte[]> viewImage(@PathVariable("fileName") String fileName) throws IOException, DataFormatException {

        byte[] fileData = fileUploadService.preview(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileData);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteImage(@PathVariable("fileName") String fileName) throws IOException {

        fileUploadService.remove(fileName);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("File deleted successfully");
    }
}

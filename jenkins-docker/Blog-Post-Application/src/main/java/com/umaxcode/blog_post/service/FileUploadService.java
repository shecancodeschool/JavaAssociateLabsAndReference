package com.umaxcode.blog_post.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public interface FileUploadService {

    /**
     * upload a file to a source
     */
    void upload(MultipartFile file) throws IOException;

    /**
     * remove an uploaded file from a source
     */
    void remove(String fileName) throws FileNotFoundException;

    /**
     * retrieve a uploaded file to be previewed
     * @return the file
     */
    byte[] preview(String fileName) throws DataFormatException, FileNotFoundException;
}

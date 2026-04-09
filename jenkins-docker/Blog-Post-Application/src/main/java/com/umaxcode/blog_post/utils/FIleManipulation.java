package com.umaxcode.blog_post.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FIleManipulation {

    public static byte[] compress(byte[] rawBytes) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(rawBytes);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(rawBytes.length);
        byte[] buffer = new byte[4 * 1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        return outputStream.toByteArray();
    }


    public static byte[] decompress(byte[] compressedBytes) throws DataFormatException {

        Inflater inflater = new Inflater();
        inflater.setInput(compressedBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedBytes.length);
        byte[] buffer = new byte[4 * 1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        return outputStream.toByteArray();
    }
}

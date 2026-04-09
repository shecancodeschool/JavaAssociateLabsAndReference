package org.eddydashcode.reflection.class_loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    private final String directory;

    public CustomClassLoader(String directory) {
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String name) {

        byte[] bytes = loadClassFromFile(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassFromFile(String className) {
        Path path = Paths.get(directory, className + ".class");

        try (FileInputStream fis = new FileInputStream(path.toFile())) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            System.out.println(buffer.length);
            return buffer;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load class file: " + path, e);
        }
    }
}

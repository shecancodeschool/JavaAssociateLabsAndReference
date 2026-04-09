package org.eddydashcode.non_blocking_io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOPrograming {

    public static void main(String[] args) throws IOException {

        writeToFile(Paths.get("data.txt"), "Hello World");
        copyFile("data.txt", "output.txt");
    }

    public static void writeToFile(Path path, String content) {

        // Open the file channel in write mode, creating the file if it doesn't exist
        try (FileChannel channel = FileChannel.open(
                path,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            // Allocate a byte buffer and put the data into it
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());

            // Write data from the buffer to the file
            while (buffer.hasRemaining()) {
                System.out.println(channel.write(buffer));
            }

            System.out.println("Data written successfully to " + path.getParent() + "/" + path.getFileName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String sourcePath, String targetPath) throws IOException {
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);

        // Open source channel for reading
        try (FileChannel sourceChannel = FileChannel.open(source, StandardOpenOption.READ)) {

            // Open target channel for writing, creating the file if it doesn't exist
            // and truncating it if it does
            try (FileChannel targetChannel = FileChannel.open(target,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {

                // Create a buffer
                ByteBuffer buffer = ByteBuffer.allocate(8192); // 8KB buffer

                // Read from source and write to target
                while (sourceChannel.read(buffer) != -1) {
                    // Flip buffer to prepare for writing
                    buffer.flip();

                    // Write data from buffer to target file
                    while (buffer.hasRemaining()) {
                        targetChannel.write(buffer);
                    }

                    // Clear buffer to prepare for next read
                    buffer.clear();
                }

                // Force all changes to be written to disk
                targetChannel.force(true);
            }
        }
    }

}

package org.eddydashcode.java_design_patterns.behavioral.strategy.compression;

public class ClientApplication {

    public static void main(String[] args) throws Exception {
        String source = "example.txt";

        Compressor compressor = new Compressor(new ZipCompression());
        compressor.compress(source, "example.zip");

        compressor.setStrategy(new GzipCompression());
        compressor.compress(source, "example.gz");

        System.out.println("Files compressed successfully.");
    }
}

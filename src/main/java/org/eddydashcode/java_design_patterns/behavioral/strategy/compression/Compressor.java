package org.eddydashcode.java_design_patterns.behavioral.strategy.compression;

public class Compressor {

    private CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(String sourceFile, String destinationFile) throws Exception {
        strategy.compress(sourceFile, destinationFile);
    }
}

package org.eddydashcode.java_design_patterns.behavioral.strategy.compression;

public interface CompressionStrategy {
    void compress(String sourceFile, String destinationFile) throws Exception;
}

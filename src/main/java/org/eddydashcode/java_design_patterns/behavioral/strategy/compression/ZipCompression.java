package org.eddydashcode.java_design_patterns.behavioral.strategy.compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompression implements CompressionStrategy{

    @Override
    public void compress(String sourceFile, String destinationFile) throws Exception {
        try (
                FileOutputStream fos = new FileOutputStream(destinationFile);
                ZipOutputStream zos = new ZipOutputStream(fos);
                FileInputStream fis = new FileInputStream(sourceFile)
        ) {
            ZipEntry zipEntry = new ZipEntry(new File(sourceFile).getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, len);
            }

            zos.closeEntry();
        }
    }
}

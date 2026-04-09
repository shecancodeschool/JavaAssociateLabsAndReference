package org.eddydashcode.java_design_patterns.structural.proxy.file_downloader;

public class RealFileDownloader implements FileDownloader{

    @Override
    public void download(String username, String fileUrl) {
        System.out.println("Starting download for: " + fileUrl);

        for (int i = 1; i <= 10; i++) {
            simulateDownloadChunk();
            System.out.println("Download progress: " + (i * 10) + "%");
        }

        System.out.println("Download completed for: " + fileUrl);
    }

    private void simulateDownloadChunk() {
        try {
            Thread.sleep(300); // simulate time taken for a chunk
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

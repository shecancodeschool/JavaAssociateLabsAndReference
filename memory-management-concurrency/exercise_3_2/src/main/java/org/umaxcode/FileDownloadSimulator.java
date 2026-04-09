package org.eddydashcode;

public class FileDownloadSimulator implements Runnable {

    private final String fileName;

    public FileDownloadSimulator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Starting download for: " + fileName);
        try {
            // Simulate time taken to download a file
            Thread.sleep((long) (Math.random() * 3000 + 1000));
        } catch (InterruptedException e) {
            System.err.println("Download interrupted for: " + fileName);
        }
        System.out.println("Completed download for: " + fileName);

    }
}

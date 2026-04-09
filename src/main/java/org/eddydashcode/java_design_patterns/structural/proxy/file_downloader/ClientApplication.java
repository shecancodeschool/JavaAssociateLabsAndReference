package org.eddydashcode.java_design_patterns.structural.proxy.file_downloader;

public class ClientApplication {

    public static void main(String[] args) {

        FileDownloader realDownloader = new RealFileDownloader();
        FileDownloader proxy = new DownloadProxy(realDownloader);

        proxy.download("maxwell", "http://example.com/file1.zip");  // Allowed
        System.out.println(); // for spacing
        proxy.download("eve", "http://example.com/file2.zip");    // Denied
        System.out.println(); // for spacing
        proxy.download("kofi", "http://example.com/file2.zip");    // Allowed
    }
}

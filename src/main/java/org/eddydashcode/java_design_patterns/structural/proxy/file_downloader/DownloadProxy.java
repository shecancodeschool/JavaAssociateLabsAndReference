package org.eddydashcode.java_design_patterns.structural.proxy.file_downloader;

import java.util.HashSet;
import java.util.Set;

public class DownloadProxy implements FileDownloader{

    private final FileDownloader realDownloader;
    private final Set<String> authorizedUsers = new HashSet<>(Set.of("maxwell", "kofi"));

    public DownloadProxy(FileDownloader realDownloader) {
        this.realDownloader = realDownloader;
    }

    @Override
    public void download(String username, String fileUrl) {
        if (!authorizedUsers.contains(username)) {
            System.out.println("Access denied for user: " + username);
            return;
        }

        System.out.println("Authorization successful for user: " + username);
        realDownloader.download(username, fileUrl);
    }
}

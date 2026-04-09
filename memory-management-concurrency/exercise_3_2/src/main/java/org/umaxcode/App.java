package org.eddydashcode;

public class App 
{
    public static void main( String[] args )
    {
        // List of "files" to download
        String[] files = {
                "file1.pdf", "file2.jpg", "file3.mp4", "file4.docx", "file5.zip"
        };

        // Create and start a thread for each file
        for (String file : files) {
            FileDownloadSimulator downloader = new FileDownloadSimulator(file);
            downloader.run();
        }

        System.out.println("All download threads started.");

    }
}

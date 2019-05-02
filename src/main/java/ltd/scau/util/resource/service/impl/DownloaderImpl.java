package ltd.scau.util.resource.service.impl;

import ltd.scau.util.resource.entity.FileData;
import ltd.scau.util.resource.net.HttpClient;
import ltd.scau.util.resource.repository.FileDataRepository;
import ltd.scau.util.resource.service.Downloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Weijie Wu
 */
@Service
public class DownloaderImpl implements Downloader {

    @Autowired
    private FileDataRepository fileDataRepository;

    @Autowired
    private HttpClient httpClient;

    @Override
    public FileData downloadAndStore(String uri) throws IOException {
        FileData fileData = httpClient.download(uri);

        return fileData;
    }
}

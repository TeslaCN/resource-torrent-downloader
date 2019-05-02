package ltd.scau.util.resource.service;

import ltd.scau.util.resource.entity.FileData;

import java.io.IOException;

/**
 * @author Weijie Wu
 */
public interface Downloader {

    /**
     * @param uri
     * @return
     * @throws IOException
     */
    FileData downloadAndStore(String uri) throws IOException;
}

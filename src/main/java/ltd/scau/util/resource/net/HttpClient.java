package ltd.scau.util.resource.net;

import ltd.scau.util.resource.entity.FileData;

import java.io.IOException;

/**
 * @author Weijie Wu
 */
public interface HttpClient {

    /**
     * @param uri
     * @return
     * @throws IOException
     */
    String get(String uri) throws IOException;

    /**
     * @param uri
     * @return
     * @throws IOException
     */
    FileData download(String uri) throws IOException;
}

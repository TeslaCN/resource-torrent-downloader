package ltd.scau.util.resource.net.impl;

import ltd.scau.util.resource.entity.FileData;
import ltd.scau.util.resource.net.HttpClient;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Weijie Wu
 */
@Component
public class HttpClientWrapper implements HttpClient {

    private Executor executor;

    public HttpClientWrapper() {
        HttpHost proxy = new HttpHost("127.0.0.1", 1087);
        CloseableHttpClient httpClient = HttpClients.custom().setProxy(proxy).build();
        executor = Executor.newInstance(httpClient);
    }

    @Override
    public String get(String uri) throws IOException {
        return executor.execute(Request.Get(uri)).returnContent().asString(Consts.UTF_8);
    }

    @Override
    public FileData download(String uri) throws IOException {
        FileData fileData = new FileData();
        Response response = executor.execute(Request.Get(uri));
        return response.handleResponse(httpResponse -> {
            Header header = httpResponse.getHeaders("Content-Disposition")[0];
            HeaderElement element = header.getElements()[0];
            String filename = element.getParameterByName("filename").getValue();
            fileData.setUri(uri);
            fileData.setName(filename);

            byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
            fileData.setBytes(bytes);

            return fileData;
        });
    }
}

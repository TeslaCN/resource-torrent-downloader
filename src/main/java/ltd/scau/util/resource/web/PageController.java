package ltd.scau.util.resource.web;

import ltd.scau.util.resource.entity.FileData;
import ltd.scau.util.resource.net.HttpClient;
import ltd.scau.util.resource.repository.TorrentRepository;
import ltd.scau.util.resource.service.Packager;
import ltd.scau.util.resource.service.PageParser;
import ltd.scau.util.resource.service.UriFormat;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Weijie Wu
 */
@Controller
public class PageController {

    @Autowired
    private TorrentRepository torrentRepository;

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private PageParser pageParser;

    @Autowired
    private UriFormat uriFormat;

    @GetMapping("/")
    public String index() {
        return "forward:/list";
    }

    @GetMapping("/list")
    public ModelAndView lists(String uri, String urn) throws IOException {
        String targetUri = Optional.ofNullable(uri).orElse(uriFormat.format(urn));
        ModelAndView view = new ModelAndView("list");
        view.addObject("items", pageParser.parseList(httpClient.get(targetUri)));
        return view;
    }

    @GetMapping("/search")
    public String search(String key, Integer page) throws UnsupportedEncodingException {
        return String.format("forward:/list?urn=%s", uriFormat.formatSearch(URLEncoder.encode(key, CharEncoding.UTF_8), page));
    }

    @GetMapping("/attachments")
    public ModelAndView attachments(String urn) throws IOException {
        ModelAndView view = new ModelAndView("attachments");
        view.addObject("floors", pageParser.parsePost(httpClient.get(uriFormat.format(urn))));
        return view;
    }

    @Autowired
    private Packager packager;

    @RequestMapping("/package")
    public ResponseEntity<byte[]> pack(String[] uris) throws IOException {
        List<FileData> fileDatas = Arrays.stream(uris).map(uri -> {
            try {
                return httpClient.download(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        packager.zip(fileDatas, byteArrayOutputStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", String.format("%s.zip", new Date()));
        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.CREATED);
    }
}

package ltd.scau.util.resource.service.impl;

import ltd.scau.util.resource.service.UriFormat;
import org.apache.commons.codec.CharEncoding;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author Weijie Wu
 */
@Service
public class BtbttUriFormatImpl implements UriFormat {

    @Override
    public String baseUri() {
        return "http://www.btbtt.co/";
    }

    @Override
    public String format(String urn) {
        return baseUri() + Optional.ofNullable(urn).orElse("");
    }

    @Override
    public String formatSearch(String key, Integer page) {
        try {
            return String.format("search-index-fid-0-orderby-timedesc-daterage-0-keyword-%s-page-%d.htm",
                    URLEncoder.encode(key, CharEncoding.UTF_8),
                    Optional.ofNullable(page).orElse(1));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
